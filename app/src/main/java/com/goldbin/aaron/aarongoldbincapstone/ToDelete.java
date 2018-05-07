package com.goldbin.aaron.aarongoldbincapstone;

public class ToDelete {

//    Button saveToExternalStorage =
//            (Button) findViewById(R.id.saveExternalStorage);
//        saveToExternalStorage.setOnClickListener(this);
//
//    Button readFromExternalStorage =
//            (Button) findViewById(R.id.getExternalStorage);
//        readFromExternalStorage.setOnClickListener(this);

    //check if external storage is available and not read only
    // TODO   Did you add permission to the AndroidManifest in order to write to storage?
//        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
//        saveToExternalStorage.setEnabled(false);  // disable to button to store
//    }
//        else {
//        myExternalFile = new File(getExternalFilesDir(filepath), filename);
//    }

//            case R.id.saveExternalStorage:
//            try {
//        FileOutputStream fos = new FileOutputStream(myExternalFile);
//
//        Log.d(TAG, readableFileSize(myExternalFile.getTotalSpace())); // dumps "12.9 GB" for me
//        Log.d(TAG, readableFileSize(myExternalFile.getFreeSpace())); // dumps "10.6 GB" for me
//
//        fos.write(myInputText.getText().toString().getBytes());
//        fos.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//                myInputText.setText("");
//                responseText
//                        .setText(filename + " saved to External Storage...");
//                break;
//
//            case R.id.getExternalStorage:
//            try {
//        FileInputStream fis = new FileInputStream(myExternalFile);
//        DataInputStream in = new DataInputStream(fis);
//        BufferedReader br = new BufferedReader(new InputStreamReader(in));
//        String strLine;
//        while ((strLine = br.readLine()) != null) {
//            myData = myData + strLine;
//        }
//        in.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//                myInputText.setText(myData);
//                responseText.setText(filename + " data retrieved from External Storage...");
//                break;
//
//}
//    }
//
//private static boolean isExternalStorageReadOnly() {
//        String extStorageState = Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
//        Log.d("Debug", "MEDIA_MOUNTED_READ_ONLY-- external storage is read only");
//        return true;
//        }
//        Log.d("Debug", "MEDIA_MOUNTED_READ_ONLY-- external storage is NOT read only");
//        return false;
//        }
//
//private static boolean isExternalStorageAvailable() {
//        String extStorageState = Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
//        Log.d("Debug", "MEDIA_MOUNTED--External Storage is Available");
//        return true;
//        }
//        Log.d("Debug", "MEDIA_MOUNTED--External Storage is NOT Available");
//        return false;
//        }
//
//    public static String readableFileSize(long size) {
//        if(size <= 0) return "0";
//        final String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
//        int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
//        return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
//    }
}
