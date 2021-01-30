package com.jedisebas.systemyliczbowe.ui.notifications;

import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.jedisebas.systemyliczbowe.IsEmptyException;

public class NotificationsViewModel extends ViewModel {

    public NotificationsViewModel() {
    }

    public void binToZm(EditText bin, EditText zm) {
        String binaryStr = bin.getText().toString().trim();
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i < binaryStr.length(); i++) {
                out += binaryStr.charAt(i);
            }
            zm.setText(out);
        } else {
            zm.setText("0" + binaryStr);
        }
    }

    public void binToUo(EditText bin, EditText uo) {
        String binaryStr = bin.getText().toString().trim();
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i<binaryStr.length(); i++) {
                if (binaryStr.charAt(i) == '0') {
                    out += "1";
                } else {
                    out += "0";
                }
            }
        } else {
            out = "0" + binaryStr;
        }
        uo.setText(out);
    }

    public void binToUt(EditText bin, EditText ut) {
        String binaryStr = bin.getText().toString().trim();
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i<binaryStr.length(); i++) {
                if (binaryStr.charAt(i) == '0') {
                    out += "1";
                } else {
                    out += "0";
                }
            }
        } else {
            out = "0" + binaryStr;
        }
        int decimal=Integer.parseInt(out,2);
        decimal++;
        if (binaryStr.charAt(0) == '-') {
            ut.setText(Integer.toBinaryString(decimal));
        } else {
            ut.setText("0" + Integer.toBinaryString(decimal));
        }
    }

    public void zmToBin(EditText zm, EditText bin) {
        String zmStr = zm.getText().toString().trim();
        String out = "";
        if (zmStr.charAt(0) == '1') {out += "-";}
        for (int i=1; i<zmStr.length(); i++) {
            out += zmStr.charAt(i);
        }
        bin.setText(out);
    }

    public void zmToUo(EditText zm, EditText uo) {
        String zmStr = zm.getText().toString().trim();
        String binaryStr = "";
        if (zmStr.charAt(0) == '1') {binaryStr += "-";}
        for (int i=1; i<zmStr.length(); i++) {
            binaryStr += zmStr.charAt(i);
        }
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i<binaryStr.length(); i++) {
                if (binaryStr.charAt(i) == '0') {
                    out += "1";
                } else {
                    out += "0";
                }
            }
        } else {
            out = "0" + binaryStr;
        }
        uo.setText(out);
    }

    public void zmToUt(EditText zm, EditText ut) {
        String zmStr = zm.getText().toString().trim();
        String binaryStr = "";
        if (zmStr.charAt(0) == '1') {binaryStr += "-";}
        for (int i=1; i<zmStr.length(); i++) {
            binaryStr += zmStr.charAt(i);
        }
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i<binaryStr.length(); i++) {
                if (binaryStr.charAt(i) == '0') {
                    out += "1";
                } else {
                    out += "0";
                }
            }
        } else {
            out = "0" + binaryStr;
        }
        int decimal=Integer.parseInt(out,2);
        decimal++;
        if (binaryStr.charAt(0) == '-') {
            ut.setText(Integer.toBinaryString(decimal));
        } else {
            ut.setText("0" + Integer.toBinaryString(decimal));
        }
    }

    public void uoToBin(EditText uo, EditText bin) {
        String uoStr = uo.getText().toString().trim();
        String out = "";
        if (uoStr.charAt(0) == '1') {
            out += "-";
            for (int i = 1; i<uoStr.length(); i++) {
                if (uoStr.charAt(i) == '0') {
                    out += "1";
                } else {
                    out += "0";
                }
            }
        } else {
            for (int i = 1; i<uoStr.length(); i++) {
                out += uoStr.charAt(i);
            }
        }
        bin.setText(out);
    }

    public void uoToZm(EditText uo, EditText zm) {
        String uoStr = uo.getText().toString().trim();
        String binaryStr = "";
        if (uoStr.charAt(0) == '1') {
            binaryStr += "-";
            for (int i = 1; i<uoStr.length(); i++) {
                if (uoStr.charAt(i) == '0') {
                    binaryStr += "1";
                } else {
                    binaryStr += "0";
                }
            }
        } else {
            for (int i = 1; i<uoStr.length(); i++) {
                binaryStr += uoStr.charAt(i);
            }
        }
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i < binaryStr.length(); i++) {
                out += binaryStr.charAt(i);
            }
            zm.setText(out);
        } else {
            zm.setText("0" + binaryStr);
        }
    }

    public void uoToUt(EditText uo, EditText ut) {
        String uoStr = uo.getText().toString().trim();
        int decimal=Integer.parseInt(uoStr,2);
        decimal++;
        if (uoStr.charAt(0) == '1') {
            ut.setText(Integer.toBinaryString(decimal));
        } else {
            ut.setText("0" + Integer.toBinaryString(decimal));
        }
    }

    public void utToUo(EditText ut, EditText uo) {
        String utStr = ut.getText().toString().trim();
        int decimal=Integer.parseInt(utStr,2);
        decimal--;
        if (utStr.charAt(0) == '1') {
            uo.setText(Integer.toBinaryString(decimal));
        } else {
            uo.setText("0" + Integer.toBinaryString(decimal));
        }
    }

    public void letsCountThat(EditText bin, EditText zm, EditText uo, EditText ut) throws IsEmptyException {
        try {
            String str = bin.getText().toString().trim();
            if (str.isEmpty())
                throw new IsEmptyException();
            binToZm(bin, zm);
            binToUo(bin, uo);
            binToUt(bin, ut);
        } catch (IsEmptyException e) {
            try {
                String str = zm.getText().toString().trim();
                if (str.isEmpty())
                    throw new IsEmptyException();
                zmToBin(zm, bin);
                zmToUo(zm, uo);
                zmToUt(zm, ut);
            } catch (IsEmptyException e2) {
                try {
                    String str = uo.getText().toString().trim();
                    if (str.isEmpty())
                        throw new IsEmptyException();
                    uoToBin(uo, bin);
                    uoToZm(uo, zm);
                    uoToUt(uo, ut);
                } catch (IsEmptyException e3) {
                    try {
                        String str = ut.getText().toString().trim();
                        if (str.isEmpty())
                            throw new IsEmptyException();
                        utToUo(ut, uo);
                        uoToBin(uo, bin);
                        uoToZm(uo, zm);
                    } catch (IsEmptyException e4) {
                        bin.setText("-101");
                        zm.setText("1101");
                        uo.setText("1010");
                        ut.setText("1011");
                    }
                }
            }
        }
    }
}