/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diction;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

/**
 *
 * @author HOLYEYED
 */
public class func {

    public boolean uc , pc ;

    public String kdau(String x) {
        String dau = "áàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòõỏọôốồổỗộơớờởỡợúùủũụưứừửữựûýỳỷỹỵđÁÀẢÃẠÂẤẦẨẪẬĂẰẮẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐÐ";
        String kda = "aaaaaaaaaaaaaaaaaeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuuyyyyydAAAAAAAAAAAAAAAAAEEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYYDD";
        for (int i = 0; i < kda.length(); i++) {
            x = x.replace(dau.charAt(i), kda.charAt(i));
            //out(i+"\t"+dau.length());
        }
        return x;
    }

    public void write(String fn, byte[] dt) {
        try {
            File f = new File(fn);
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(dt);
            fos.close();
        } catch (Exception e) {
            out("khong xong " + fn + " " + e.getMessage());
        }
    }

    public void md(String dir) {
        try {
            File d = new File(dir);
            if (!d.exists()) {
                d.mkdirs();
            }
        } catch (Exception e) {
        }
    }

    public boolean check(String fn) {
        try {
            File f = new File(fn);
            return f.exists();
        } catch (Exception e) {
        }
        return false;
    }

    public void pushout() {
        String[] a = {"raw/wfc", "raw/thx", "make.cmd", "name.txt", "salt.txt", "use", "father.txt"};
        for (int i = 0; i < a.length; i++) {
            if (!check(a[i])) {
                try {
                    InputStream is = "".getClass().getResourceAsStream("/" + a[i]);
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    write(a[i], b);
                } catch (Exception e) {

                }
            }
        }
        //tinhthanh();
    }

    public void out(Object f) {
        System.out.println("" + f);
    }

//    public void numberphone(String dauso) {
//        Random rd = new Random();
//        uppend up = new uppend(dauso);
//        for (int i = 0; i < 10000000; i += 3) {
//            String p = "" + (i + rd.nextInt(3));
//            while (p.length() < 7) {
//                p = "0" + p;
//            }
//            String ns = dauso + p + "\n";
//            up.uppend(ns);
//        }
//        up.close();
//    }
    public ArrayList getfile(String fn) {
        try {
            ArrayList ar = new ArrayList();
            FileReader f = new FileReader(fn);
            BufferedReader br = new BufferedReader(f);
            String nl;
            int c = 0;
            while ((nl = br.readLine()) != null) {
                ar.add(nl);
                c++;
            }
            return ar;
        } catch (Exception e) {
            out("Cant load file " + fn);
        }
        return new ArrayList();
    }

    public String upper(String c, int[] pos) {
        String rt = "";
        int ni = 0;
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] > ni) {
                rt += c.substring(ni, pos[i]);
            }
            rt += ("" + c.charAt(pos[i])).toUpperCase();
            ni = pos[i] + 1;
        }
        if (ni < c.length()) {
            rt += c.substring(ni);
        }
        return rt;
    }

    public String readfile(String fn) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bos);
            byte[] bf = new byte[12020];
            int c;
            FileInputStream fis = new FileInputStream(new File(fn));
            while ((c = fis.read(bf)) > 0) {
                dos.write(bf, 0, c);
            }
            fis.close();
            bf = bos.toByteArray();
            dos.close();
            bos.close();
            return new String(bf, "utf-8");
        } catch (Exception e) {
        }
        return null;
    }

    public void them(uppend u, String m) {
        //them vao tu dien
        if (u != null) {
            if (m.length() >= 8 && m.length() <= 17) {
                u.uppend(m + "\n");
            }
        }
    }

    public ArrayList ghep(ArrayList a, ArrayList b, uppend u) {
        //out(a.size() + "\t" + b.size());
        ArrayList nh = new ArrayList();
        try {
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < b.size(); j++) {
                    String as = (String) a.get(i), bs = (String) b.get(j);
                    if (as.length() > 1 && as.charAt(0) >= 'A' && (as.equals(bs))) {
                        //neu trung nhau hai tu thi khong ghep lai voi nhau
                        //out("*****\t\tDuplicate \t[" + as + bs + "]");
                    } else {
                        String m = as + bs, tmp;
                        nh.add(m);
                        them(u, m);
                        if (pc) {
                            tmp = toProper(as) + toProper(bs);
                            if (!tmp.equals(m)) {
                                nh.add(tmp);
                                them(u, tmp);
                            }
                            tmp = toProper(as) + bs;
                            if (!tmp.equals(m)) {
                                nh.add(tmp);
                                them(u, tmp);
                            }
                        }
                        if (uc) {
                            tmp = m.toUpperCase();
                            if (!tmp.equals(m)) {
                                nh.add(tmp);
                                them(u, tmp);
                            }
                        }

                    }
                }
            }
        } catch (Exception e) {
            out("ERROR ON COMBINE WORDS " + e.getMessage());

        }

        return nh;
    }

    public String toProper(String f) {
        if (f.length() > 0) {
            char a = f.charAt(0);
            if (f.length() > 0 && a >= 'a' && a <= 'z') {
                return f.substring(0, 1).toUpperCase() + f.substring(1);
            }
        }
        return f;
    }

    public void clean(String fn, uppend u) {
        try {

            FileReader fr = new FileReader(fn);
            BufferedReader bw = new BufferedReader(fr);
            HashSet master = new HashSet();
            String c;
            while ((c = bw.readLine()) != null) {
                if (c.length() >= 8 && !master.contains(c)) {
                    master.add(c);
                    u.uppend(c + "\n");
                }
            }
            bw.close();
            fr.close();
            u.close();
            File f = new File(fn);
            f.delete();
        } catch (Exception e) {
            out(fn + " khong biet " + e.getMessage());
        }
    }

    public void getdata() {
        String mh = readfile("dulieu/ten.txt");
        out("xong 1" + mh.length());
        mh = kdau(mh);
        out("xong 2" + mh.length());
        String[] an = mh.split("\n");
        ArrayList ho = new ArrayList(), ten = new ArrayList(), cho = new ArrayList(), cten = new ArrayList();
        out("xong 3" + an.length);
        for (int i = 0; i < an.length; i++) {
            //out("\t"+(i*100/an.length));
            String[] aw = an[i].split(" ");
            int id = ho.indexOf(aw[0]);

            if (id == -1) {
                ho.add(aw[0]);
                cho.add("" + 1);
            } else {
                int cc = Integer.parseInt((String) cho.get(id)) + 1;
                cho.set(id, "" + cc);
            }
            if (aw.length > 3) {
                id = ho.indexOf(aw[1]);
                if (id == -1) {
                    ho.add(aw[1]);
                    cho.add("" + 1);
                } else {
                    int cc = Integer.parseInt((String) cho.get(id)) + 1;
                    cho.set(id, "" + cc);
                }
            }
            id = ten.indexOf(aw[aw.length - 1]);
            if (id == -1) {
                ten.add(aw[aw.length - 1]);
                cten.add("" + 1);
            } else {
                int cc = Integer.parseInt((String) cten.get(id)) + 1;
                cten.set(id, "" + cc);
            }
        }
        out("write data ///////////////////////////////////");
        uppend up0 = new uppend("dulieu/ften.txt");
        for (int i = 0; i < cten.size(); i++) {
            up0.uppend(cten.get(i) + "\t" + ten.get(i) + "\n");
        }
        up0.close();
        uppend up1 = new uppend("dulieu/fho.txt");
        for (int i = 0; i < cho.size(); i++) {
            up1.uppend(cho.get(i) + "\t" + ho.get(i) + "\n");
        }
        up1.close();
        out(ho.size() + "/" + ten.size());
        //out(ho.toString() + "/" + ten.toString());
    }

    public void tinhthanh() {
        try {
            String dt = readfile("dulieu/area");
            dt = kdau(dt);
            String[] adt = dt.split("\r\n");
            String wdt = "";
            for (int i = 0; i < adt.length; i++) {
                wdt += adt[i].toLowerCase().replace(" ", "") + "\n";
                wdt += adt[i].replace(" ", "") + "\n";
                wdt += adt[i].toUpperCase().replace(" ", "") + "\n";
            }
            write("thx", wdt.getBytes());
            out("viet thanh cong thx");
        } catch (Exception e) {
            out("viet file thx thành sai");
        }

    }

    public int cyear() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year;
    }
}
