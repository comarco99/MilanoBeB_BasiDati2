import json
import numpy as np
import pandas as pd
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

geo_json={}#intero oggetto json di un singolo airbnb
cordinate_list=[]#lista per due cordinate
geo_json_list=[]
listing=pd.read_csv("C:/Users/costa/Desktop/BD2/PROGETTO/DataSet_Cleaned/listing.csv")


lat=pd.DataFrame(listing.iloc[:,4])
long=pd.DataFrame(listing.iloc[:,5])
id=pd.DataFrame(listing.iloc[:,0])
location_json={}
for i in range(lat.shape[0]):
    for j in range(lat.shape[1]):
        cordinate_list.append(long.iloc[i, j])
        cordinate_list.append(lat.iloc[i,j])
        geo_json["id"]=id.iloc[i,j]
        location_json["coordinates"]=cordinate_list
        location_json["type"] = "Point"
        geo_json["location"]=location_json
        geo_json_list.append(geo_json)
    cordinate_list=[]
    geo_json={}
    location_json={}

jsonfile = open("C:/Users/costa/Desktop/BD2/PROGETTO/Locations.json","w")
for data in geo_json_list:
    jsonfile.write(json.dumps(data, indent=3, cls=NumpyEncoder))#cls=NumpyEncoder necessario perchè da errore di Serializable
jsonfile.close()