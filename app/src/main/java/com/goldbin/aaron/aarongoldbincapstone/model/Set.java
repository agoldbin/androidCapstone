package com.goldbin.aaron.aarongoldbincapstone.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Set {
    package com.example.student.demostoragesqlite;

/**
 * Created by student on 5/5/2015.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

    public class MyDBHandler extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "productDB.db";
        private static final String TABLE_PRODUCTS = "products";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_PRODUCTNAME = "productname";
        public static final String COLUMN_QUANTITY = "quantity";

        public MyDBHandler(Context context, String name,
                           SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        }

        /**
         implemented so that the products table is created when the database
         is first initialized. This involves constructing a SQL CREATE
         statement containing instructions to create a new table with the
         appropriate columns and then passing that through to the execSQL()
         method of the SQLiteDatabase object passed as an argument to onCreate():
         */
        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                    TABLE_PRODUCTS + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PRODUCTNAME
                    + " TEXT," + COLUMN_QUANTITY + " INTEGER" + ")";



            db.execSQL(CREATE_PRODUCTS_TABLE);

            // load dummy data
            //call to class to create dummy data (read txt file which creates productArray) and
            // then return the product
            //addDummyData(productArray);

        }

        /**
         *   called when the handler is invoked with a greater database version
         *   number from the one previously used. The exact steps to be performed
         *   in this instance will be application specific, so for the purposes
         *   of this example we will simply remove the old database and create a new one
         *
         * @param db
         * @param oldVersion
         * @param newVersion
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
            onCreate(db);
        }

        /**
         *  insert database records
         *
         * @param product  an instance of our Product data model class
         */
        public void addProduct(Product product) {

            ContentValues values = new ContentValues();
            //content object primed with key-value pairs for the data columns extracted from the Product object
            values.put(COLUMN_PRODUCTNAME, product.getProductName());
            values.put(COLUMN_QUANTITY, product.getQuantity());

            //  a reference to the database will be obtained
            SQLiteDatabase db = this.getWritableDatabase();

            // insert the record
            db.insert(TABLE_PRODUCTS, null, values);
            // close the database
            db.close();
        }

        /**
         *   query the Product database
         *
         * @param productname  String object containing the name of the product to be located
         * @return
         */
        public Product findProduct(String productname) {
            String query = "Select * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + " =  \"" + productname + "\"";

            SQLiteDatabase db = this.getWritableDatabase();

            Cursor cursor = db.rawQuery(query, null);

            Product product = new Product();

            //only the first match will then be returned, contained within a
            // new instance of our Product data model class
            if (cursor.moveToFirst()) {
                cursor.moveToFirst();
                product.setID(Integer.parseInt(cursor.getString(0)));
                product.setProductName(cursor.getString(1));
                product.setQuantity(Integer.parseInt(cursor.getString(2)));
                cursor.close();
            } else {
                product = null;
            }
            db.close();
            return product;
        }

        /**
         *
         *
         * @param productname  the entry to be deleted in the form of a Product object
         * @return
         */
        public boolean deleteProduct(String productname) {

            boolean result = false;

            String query = "Select * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + " =  \"" + productname + "\"";

            // search for the entry based on the product name
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);

            Product product = new Product();

            // if located, delete it from the table
            if (cursor.moveToFirst()) {
                product.setID(Integer.parseInt(cursor.getString(0)));
                db.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?",
                        new String[] { String.valueOf(product.getID()) });
                cursor.close();
                result = true;
            }
            db.close();
            return result;
        }


    }

}
