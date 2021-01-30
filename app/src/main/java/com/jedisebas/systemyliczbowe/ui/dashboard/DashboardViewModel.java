package com.jedisebas.systemyliczbowe.ui.dashboard;

import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.jedisebas.systemyliczbowe.IsEmptyException;

public class DashboardViewModel extends ViewModel {

    public DashboardViewModel() {
    }

    public void decToBin(EditText dec, EditText bin) {
        int decimal = Integer.parseInt(dec.getText().toString().trim());
        bin.setText(Integer.toBinaryString(decimal));
    }

    public void decToOct(EditText dec, EditText oct) {
        int decimal = Integer.parseInt(dec.getText().toString().trim());
        String binaryStr = Integer.toBinaryString(decimal);
        int binary = Integer.parseInt(binaryStr, 2);
        String octalStr = Integer.toOctalString(binary);
        oct.setText(octalStr);
    }

    public void decToHex(EditText dec, EditText hex) {
        int decimal = Integer.parseInt(dec.getText().toString().trim());
        String hexadecimalStr = Integer.toHexString(decimal);
        hex.setText(hexadecimalStr.toUpperCase());
    }

    public void binToDec(EditText bin, EditText dec) {
        String binaryString = bin.getText().toString().trim();
        int decimal=Integer.parseInt(binaryString,2);
        String decStr = Integer.toString(decimal);
        dec.setText(decStr);
    }

    public void binToOct(EditText bin, EditText oct) {
        String binaryStr = bin.getText().toString().trim();
        int binary = Integer.parseInt(binaryStr, 2);
        String octalStr = Integer.toOctalString(binary);
        oct.setText(octalStr);
    }

    public void binToHex(EditText bin, EditText hex) {
        String binaryStr = bin.getText().toString().trim();
        int binary = Integer.parseInt(binaryStr, 2);
        String hexadecimalStr = Integer.toHexString(binary);
        hex.setText(hexadecimalStr.toUpperCase());
    }

    public void octToDec(EditText oct, EditText dec) {
        String octalStr = oct.getText().toString().trim();
        int decimal = Integer.parseInt(octalStr, 8);
        String decStr = Integer.toString(decimal);
        dec.setText(decStr);
    }

    public void octToBin(EditText oct, EditText bin) {
        String octalStr = oct.getText().toString().trim();
        int decimal = Integer.parseInt(octalStr, 8);
        bin.setText(Integer.toBinaryString(decimal));
    }

    public void octToHex(EditText oct, EditText hex) {
        String octalStr = oct.getText().toString().trim();
        int decimal = Integer.parseInt(octalStr, 8);
        String hexadecimalStr = Integer.toHexString(decimal);
        hex.setText(hexadecimalStr.toUpperCase());
    }

    public void hexToBin(EditText hex, EditText bin) {
        String hexadecimalStr = hex.getText().toString().trim();
        int decimal = Integer.parseInt(hexadecimalStr, 16);
        bin.setText(Integer.toBinaryString(decimal));
    }

    public void hexToDec(EditText hex, EditText dec) {
        String hexadecimalStr = hex.getText().toString().trim();
        int decimal = Integer.parseInt(hexadecimalStr, 16);
        String decimalStr = Integer.toString(decimal);
        dec.setText(decimalStr);
    }

    public void hexToOct(EditText hex, EditText oct) {
        String hexadecimalStr = hex.getText().toString().trim();
        int decimal = Integer.parseInt(hexadecimalStr, 16);
        String octalStr = Integer.toOctalString(decimal);
        oct.setText(octalStr);
    }

    public void letsDoThat(EditText dec, EditText bin, EditText oct, EditText hex) throws IsEmptyException {
        try {
            String str = dec.getText().toString().trim();
            if (str.isEmpty())
                throw new IsEmptyException();
            decToBin(dec, bin);
            decToOct(dec, oct);
            decToHex(dec, hex);
        } catch (IsEmptyException e) {
            try {
                String str = bin.getText().toString().trim();
                if (str.isEmpty())
                    throw new IsEmptyException();
                binToDec(bin, dec);
                binToOct(bin, oct);
                binToHex(bin, hex);
            } catch (IsEmptyException e2) {
                try {
                    String str = oct.getText().toString().trim();
                    if (str.isEmpty())
                        throw new IsEmptyException();
                    octToDec(oct, dec);
                    octToBin(oct, bin);
                    octToHex(oct, hex);
                } catch (IsEmptyException e3) {
                    try {
                        String str = hex.getText().toString().trim();
                        if (str.isEmpty())
                            throw new IsEmptyException();
                        hexToBin(hex, bin);
                        hexToDec(hex, dec);
                        hexToOct(hex, oct);
                    } catch (IsEmptyException e4) {
                        dec.setText("15");
                        bin.setText("1111");
                        oct.setText("17");
                        hex.setText("F");
                    }
                }
            }
        }
    }
}
