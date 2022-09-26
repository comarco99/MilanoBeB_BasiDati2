import numpy as np
import pandas as pd
import json

import json
import numpy as np

#classe necessaria altrimenti da errore nella scrittura su file
class NumpyEncoder(json.JSONEncoder):
    """ Custom encoder for numpy data types """
    def default(self, obj):
        if isinstance(obj, (np.int_, np.intc, np.intp, np.int8,
                            np.int16, np.int32, np.int64, np.uint8,
                            np.uint16, np.uint32, np.uint64)):

            return int(obj)

        elif isinstance(obj, (np.float_, np.float16, np.float32, np.float64)):
            return float(obj)

        elif isinstance(obj, (np.complex_, np.complex64, np.complex128)):
            return {'real': obj.real, 'imag': obj.imag}

        elif isinstance(obj, (np.ndarray,)):
            return obj.tolist()

        elif isinstance(obj, (np.bool_)):
            return bool(obj)

        elif isinstance(obj, (np.void)):
            return None

        return json.JSONEncoder.default(self, obj)

#importo i dati del dataset in dei pandas dataframe
calendar=pd.read_csv("C:/Users/costa/Desktop/BD2/PROGETTO/DataSet_Cleaned/calendar.csv")
listing=pd.read_csv("C:/Users/costa/Desktop/BD2/PROGETTO/DataSet_Cleaned/listing.csv")
neighbourhoods=pd.read_csv("C:/Users/costa/Desktop/BD2/PROGETTO/DataSet_Cleaned/neighbourhoods.csv")
reviews=pd.read_csv("C:/Users/costa/Desktop/BD2/PROGETTO/DataSet_Cleaned/reviews.csv")

#vogliamo creare un unico grande dataframe dal quale otterremo i file json per il popolamento
#del database su mongodb
#aggiungo il campo neighbourhood a listing
listing_neighbourhood=pd.merge(listing,neighbourhoods, left_on='neighbourhood', right_on='neighbourhood')

listing_json={}#oggetto json totale per il listing
review_json={}#oggetto json contenente una review (per un singolo listing)
#calendar_json={}#oggetto json contenete una calendar
review_list=[]#lista di tutti i review_json di un listing_json
#calendar_list=[]#lista di tutti i calendar_json di un listing_json
listing_list=[]#lista di tutti i listing_json

#review e listing_neighbourhood hanno un listing_id condiviso che permette l'unione

for riga in range(listing_neighbourhood.shape[0]):#per ogni riga di tutti i listing
    for col in range(listing_neighbourhood.shape[1]):#per ogni riga di tutti i listing

        listing_json[listing_neighbourhood.columns[col]]=listing_neighbourhood.iloc[riga,col]#man mano in listing_json va il singolo elemento di listing (listing_id, name, neigh, lat, ecc)

    review_per_listing=reviews.loc[reviews['listing_id']==listing_neighbourhood['listing_id'][riga]]#man mano viene messo il review coincidente con listing id di listing

    for rev in range(review_per_listing.shape[0]):#per ogni riga di review per listing
        for col in range(review_per_listing.shape[1]):#per ogni colonna
            data2 = review_per_listing.iloc[rev, col]
            if isinstance(data2, (np.int_, np.intc, np.intp, np.int8,
                                    np.int16, np.int32, np.int64, np.uint8,
                                    np.uint16, np.uint32, np.uint64)):
                if np.isnan(data2):
                    pass
            elif data2 != data2:
                pass
            else:
                review_json[review_per_listing.columns[col]] = data2 #costruisco singolo oggetto json review

        review_list.append(review_json)#alla lista di tutti i review aggiungo quello nuovo
        review_json = {}


    #listing_json['calendars'] = calendar_list #aggiungo all'oggetto json corrente di tipo listing il campo calendars (contenente i calendar di un listing)
    listing_json['reviews'] = review_list #aggiungo all'oggetto json corrente di tipo listing il campo reviews (contenente tutti i review di un listing)

    listing_list.append(listing_json) #alla lista di tutti i listing, aggiungo l'oggetto json rappresentate il listing corrente costruito

    #calendar_list = [] #svuoto le liste e gli oggetti che serviranno nell'iterazione successiva per costruire un nuovo oggetto json di tipoo listing
    review_list=[]
    listing_json = {}

#salvo in un file json i dati che andranno a costituire la collection unica rappresentante gli AirB&B
#con i calendar e le reviews per ognuno di essi
jsonfile = open("C:/Users/costa/Desktop/BD2/PROGETTO/MilanoTotalCollection.json","w")
for data in listing_list:
    jsonfile.write(json.dumps(data, indent=3, cls=NumpyEncoder))#cls=NumpyEncoder necessario perchè da errore di Serializable
jsonfile.close()