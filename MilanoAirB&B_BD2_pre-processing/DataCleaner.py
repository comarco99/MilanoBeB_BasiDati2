import pandas as pd



path_cleaned="C:/Users/costa/Desktop/BD2/PROGETTO/DataSet_Cleaned/"

if __name__ == '__main__':

    #importo i dati del dataset in dei pandas dataframe
    listing=pd.read_csv("C:/Users/costa/Desktop/BD2/PROGETTO/Kaggle_Dataset/listings_summary.csv")
    neighbourhoods=pd.read_csv("C:/Users/costa/Desktop/BD2/PROGETTO/Kaggle_Dataset/neighbourhoods_summary.csv")
    reviews=pd.read_csv("C:/Users/costa/Desktop/BD2/PROGETTO/Kaggle_Dataset/reviews.csv")

    #analizzo il dataframe listing
    print("+++++++++++LISTING\n", listing.head())
    print("Listing size: ", listing.shape)
    print("Listing columns: ", listing.columns.tolist())
    print("Listing NaN values: ", listing.columns[listing.isna().any()].tolist())

    #rimuovo colonne ridondanti
    #listing.drop('price', axis=1, inplace=True)
    listing.drop('minimum_nights', axis=1, inplace=True)

    #rinomino id per facilitare le operazioni successive
    listing.rename(columns={'id':'listing_id'}, inplace=True)

    #rimuovo la colonna neighbourhood group, costituita totalmente da valori null
    listing.drop('neighbourhood_group', axis=1, inplace=True)

    #rimuovo la colonna host_id, last_review, reviewpermont, availability365,calculatedhostlistinf che non verrà gestita
    listing.drop('host_id', axis=1, inplace=True)
    listing.drop('last_review', axis=1, inplace=True)
    listing.drop('reviews_per_month', axis=1, inplace=True)
    listing.drop('calculated_host_listings_count', axis=1, inplace=True)
    listing.drop('availability_365', axis=1, inplace=True)

    #rimuovo righe con valori nan
    listing.dropna(inplace=True)

    #salvo file ripulito
    listing.to_csv(path_cleaned + "/" + "listing.csv", index=False)


    #analizzo il dataframe neighbourhoods
    print("++++++++++++NEIGHBOURHOODS\n", neighbourhoods.head())
    print("Neighbourhoods size: ", neighbourhoods.shape)
    print("Neighbourhoods columns: ", neighbourhoods.columns.tolist())
    print("Neighbourhoods NaN values: ", neighbourhoods.columns[neighbourhoods.isna().any()].tolist())

    #elimino la colonna neighbourhood_group costituita totalmente da vaolori null
    neighbourhoods.drop('neighbourhood_group', axis=1, inplace=True)

    #salvo file ripulito
    neighbourhoods.to_csv(path_cleaned + "/" + "neighbourhoods.csv", index=False)

    #analizzo il dataframe reviews
    print("++++++++++++REVIEWS\n",reviews.head())
    print("Reviews size: ", reviews.shape)
    print("Reviews columns: ", reviews.columns.tolist())
    print("Reviews NaN values: ", reviews.columns[reviews.isna().any()].tolist())

    #rinomino date per facilitare le operazioni successive e evitare omonimie di colonne
    reviews.rename(columns={'date':'review_date'}, inplace=True)

    #elimino la colonna reviewer id che non verrà gestita
    reviews.drop('reviewer_id', axis=1, inplace=True)

    #elimino la colonna id, per evitare ridondanze
    reviews.drop('id', axis=1, inplace=True)

    #rimuovo righe con valori nan
    reviews.dropna(inplace=True)

    #salvo il file ripulito
    reviews.to_csv(path_cleaned + "/" + "reviews.csv", index=False)

