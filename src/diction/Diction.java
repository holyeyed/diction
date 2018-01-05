package diction;

import java.util.ArrayList;

public class Diction {

    public static void main(String[] args) {
        new Diction(args);
    }
    func fc = new func();
    String[] uten = {"tdung", "number", "holyw", "fname", "date", "mk"};
    uppend[] up;
    String[] dom = {"3002", "3102", "3104", "3106", "3109", "3111"};
    String abc = "0123456789abcdeghiklmnopqrstuvxy";
    ArrayList day, mon, yea, fyea, hday, hmon, sal, use, ho, ten, thx;
    int lim, cyear;
    boolean uc, pc, help, fn;
    String mk = "okeconde";
    String usage = "..........WORDLIST GENERATOR.....\n"
            + "-----------------------------------------------------------------------------\n"
            + "Parameter:\n"
            + "\tupper \tgeneral UPPERCASE words\n"
            + "\tproper \tgeneral Propercase words\n"
            + "\tmix \tenable UPPER and Proper - case\n"
            + "\tbd:xx lowest year of birth (last two digits)\n"
            + "\tmk:<text> \t3 Uppercase often pass\n"
            + "\tfn \t3 full name creation\n"
            + "GOODLUCK!\t\t\tby Holyeyed.\n";
    String[] so = {"khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin", "muoi"};

    public Diction(String[] pr) {
        //fc.getdata();
        fc.md("raw");
        fc.pushout();
        if (!fc.check("raw")) {
            fc.md("raw");
        }
        cyear = fc.cyear();
        lim = cyear - 58 - 1900;
        if (pr != null && pr.length > 0) {
            for (int i = 0; i < pr.length; i++) {
                if (pr[i].startsWith("upper")) {
                    fc.uc = true;
                }
                if (pr[i].startsWith("bd:")) {
                    lim = Integer.parseInt(pr[i].substring(3));
                }
                if (pr[i].startsWith("fn")) {
                    fn = true;
                }
                if (pr[i].startsWith("proper")) {
                    fc.pc = true;
                }
                if (pr[i].startsWith("mix")) {
                    fc.uc = true;
                    fc.pc = true;
                }
                if (pr[i].startsWith("mk:")) {
                    mk = pr[i].substring(3);
                }
                if (pr[i].equals("help") || pr[i].equals("/?") || pr[i].equals("-help") || pr[i].equals("--help")) {
                    help = true;
                }
            }
        }
        out(usage);
        if (!help) {
            rep();
            thuongdung();
            //out("sal and sal");
            ArrayList sal2 = fc.ghep(sal, sal, up[2]);
            //ghep full date and year-year
            // out("day and mon");
            ArrayList dm = fc.ghep(day, mon, null);
            for (int i = 0; i < dom.length; i++) {
                dm.remove(dom[i]);
            }
            // out("mon and year");
            ArrayList my = fc.ghep(mon, yea, null);
            //out("dm and fyear");
            ArrayList dmy = fc.ghep(dm, fyea, up[4]);
            fc.ghep(sal2, use, up[2]);
            fc.ghep(use, sal2, up[2]);
            fc.ghep(sal2, sal2, up[2]);
            // out("sal and year");
            fc.ghep(sal2, fyea, up[2]);
            fc.ghep(sal2, yea, up[2]);
            //out("sal and fdmy");
            fc.ghep(sal, dmy, up[2]);
            //ghep vao date
            fc.ghep(fyea, fyea, up[4]);
            fc.ghep(dm, dm, up[4]);
            dmy = fc.ghep(dm, yea, null);
            //ghep full holyw
            // out("sal and dmy");
            fc.ghep(sal, dmy, up[2]);
            fc.ghep(sal, ten, up[2]);
            fc.ghep(ten, sal, up[2]);
            fc.ghep(sal, dm, up[2]);
            fc.ghep(sal, my, up[2]);
            //ghep full fname
            //ArrayList ht = ghep(ho, ten, up[3]);
            //ghep(ho, use, up[3]);
            out("Combine name....");
            out("** name & name");
            fc.ghep(ten, ten, up[3]);
            my = fc.ghep(ho, ten, up[3]);
            out("** name & use");
            fc.ghep(ten, use, up[3]);
            out("** name & fyea");
            fc.ghep(ten, fyea, up[3]);
            if (fn) {
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < my.size(); j++) {
                        if (pc) {
                            String m = fc.toProper(my.get(j) + "") + "" + yea.get(i);
                            up[3].uppend(m + "\n");
                        } else {
                            String m = my.get(j) + "" + yea.get(i);
                            up[3].uppend(m + "\n");
                        }
                    }
                }
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < ten.size(); j++) {
                        for (int y = 0; y < dm.size(); y++) {
                            if (pc) {
                                String m = fc.toProper(ten.get(j) + "") + (dm.get(y) + "" + yea.get(i));
                                up[3].uppend(m + "\n");
                            } else {
                                String m = ten.get(j) + "" + (dm.get(y) + "" + yea.get(i));
                                up[3].uppend(m + "\n");
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < up.length; i++) {
                up[i].close();
            }
            for (int i = 0; i < uten.length; i++) {
                out("cleaning file \t[" + uten[i] + "]");
                fc.clean("raw/" + uten[i] + ".tmp", new uppend("raw/" + uten[i]));
            }
            out("finish************");
        }
    }

//    public void bruce(int n) {
//        try {
//            ArrayList ar = new ArrayList();
//            for (int i = 0; i < abc.length(); i++) {
//                ar.add("" + abc.charAt(i));
//            }
//            uppend ab = new uppend("abc" + n + ".txt");
//            ArrayList a = new ArrayList();
//            a.add("");
//            for (int i = 0; i < n; i++) {
//                a = fc.ghep(a, ar, null);
//            }
//            for (int i = 0; i < a.size(); i++) {
//                ab.uppend(dauso + (String) a.get(i) + "\n");
//            }
//            ab.close();
//        } catch (Exception e) {
//        }
//    }
    public void rep() {
        day = new ArrayList();
        hmon = new ArrayList();
        mon = new ArrayList();
        hday = new ArrayList();
        yea = new ArrayList();
        fyea = new ArrayList();
        sal = new ArrayList();
        ten = fc.getfile("name.txt");
        ho = fc.getfile("father.txt");
        thx = fc.getfile("raw/thx");
        for (int i = 1; i < 100; i++) {
            String x = "" + i, y = "" + i;
            if (i < 10) {
                x = "0" + i;
            }
            if (i < 13) {
                mon.add(x);
                hmon.add(y);
            }
            if (i < 32) {
                day.add(x);
                hday.add(y);
            }
            if (i >= lim) {
                yea.add(x);
                fyea.add("19" + x);
            }
        }

        for (int i = 2000; i <= cyear; i++) {
            fyea.add("" + i);
        }
        for (int i = 0; i <= cyear - 2000; i++) {
            String x = "" + i;
            if (i < 10) {
                x = "0" + i;
            }
            yea.add(x);
        }
        //
        up = new uppend[uten.length];
        for (int i = 0; i < up.length; i++) {
            up[i] = new uppend("raw/" + uten[i] + ".tmp");
        }
        //tong hop so dien thoai
        upper3letter();
        //
        sal = fc.getfile("salt.txt");
    }

    public void out(Object f) {
        System.out.println("" + f);
    }

    public void upper3letter() {
        //mk 3 upper letters
        if (up[5] != null) {
            for (int i = 0; i < mk.length(); i++) {
                up[5].uppend(fc.upper(mk, new int[]{i}) + "\n");
                for (int j = 0; j < mk.length(); j++) {
                    if (i < j) {
                        up[5].uppend(fc.upper(mk, new int[]{i, j}) + "\n");
                    }
                    for (int k = 0; k < mk.length(); k++) {

                        if (k > j && j > i) {
                            {
                                up[5].uppend(fc.upper(mk, new int[]{i, j, k}) + "\n");
                            }
                        }
                    }
                }
            }
        }
    }

    public void thuongdung() {
        try {
            use = fc.getfile("use");
            //fc.ghep(thx, use, up[0]);
            fc.ghep(use, use, up[0]);
            for (int i = 0; i <= 9; i++) {
                String thieu = "";
                for (int j = 0; j <= 9; j++) {
                    up[0].uppend("" + i + j + i + j + i + j + i + j + "\n");
                    up[0].uppend("" + i + j + i + j + i + j + i + j + i + j + "\n");
                    if (i != j && j != 0) {
                        thieu += j;
                    }
                }
                up[0].uppend(thieu + "\n");
                up[0].uppend("" + i + i + i + i + i + i + i + i + i + "\n");
            }
            for (char i = 'a'; i <= 'z'; i++) {
                up[0].uppend("" + i + i + i + i + i + i + i + i + "\n");
                up[0].uppend("" + i + i + i + i + i + i + i + i + i + "\n");
                up[0].uppend("" + i + i + i + i + i + i + i + i + i + i + "\n");
            }
            //kieu doc so
            for (int i = 0; i < so.length; i++) {
                for (int j = 0; j < so.length; j++) {
                    up[0].uppend(so[i] + "den" + so[j] + "\n");
                    up[0].uppend("tu" + so[i] + "den" + so[j] + "\n");
                    up[0].uppend(so[i] + "so" + so[j] + "\n");
                    up[0].uppend("tu" + i + "den" + j + "\n");
                }
            }
            up[0].uppend(so[0] + so[1] + so[2] + "\n");
            up[0].uppend(so[2] + so[1] + so[0] + "\n");
        } catch (Exception e) {
        }
    }

}
