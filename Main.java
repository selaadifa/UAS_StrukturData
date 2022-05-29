import java.util.*;

public class Main {
    public static class Musik {
        private String judulMusik;
        private String namaPenyanyi;

        public Musik(String judul, String penyanyi) {
            this.judulMusik = judul;
            this.namaPenyanyi = penyanyi;
        }

        public Object getJudulMusik() {
            return judulMusik;
        }

        @Override
        public String toString() {
            return "Musik{" + "Judul Musik='" + judulMusik + '\'' + ", Nama Penyanyi='" + namaPenyanyi + '\'' + "}";
        }
    }
        public static void main(String[] args) {
        LinkedList<Musik> listMusik = new LinkedList<Musik>();
        Scanner input = new Scanner(System.in);

        String judul;
        String penyanyi;
        String nextInsert;

        int command = 0;
        while (command != 5) {
            System.out.println("==== MENU ====");
            System.out.println("1. Masukkan Musik           : ");
            System.out.println("2. Hapus Musik              : ");
            System.out.println("3. Hapus Musik Yang Dipilih  : ");
            System.out.println("4. Mainkan Musik ");
            System.out.println("5. Keluar ");

            System.out.println("");
            System.out.print("Pilih Menu : ");

            command = input.nextInt();
            input.nextLine();

            System.out.println();

            ListIterator<Musik> iterator = listMusik.listIterator();

            switch (command) {
                case 1:
                    do {
                        System.out.print("Judul Musik   : ");
                        judul = input.nextLine();

                        System.out.print("Nama Penyanyi : ");
                        penyanyi = input.nextLine();

                        listMusik.addLast(new Musik(judul, penyanyi));

                        System.out.print("\nLanjutkan y/n ? ");
                        nextInsert = input.nextLine();
                        System.out.println("");
                        System.out.println("Musik berhasil ditambahkan");
                        System.out.println("");
                    }
                    while (nextInsert.equalsIgnoreCase("Y"));
                    break;
                case 2:
                    System.out.print("Berhasil menghapus lagu di list terakhir");
                    listMusik.removeLast();
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Masukan judul");

                    String hapus = input.nextLine();

                    ListIterator<Musik> iter = listMusik.listIterator();
                    while (iter.hasNext()){
                        Musik ob = iter.next();
                        if (ob.getJudulMusik().equals(hapus)){
                            iter.remove();
                        }
                    }
                    System.out.println("Berhasil menghapus " + hapus + "!!");
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Putar musik dari awal ");

                    while (iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    System.out.println("");
                    System.out.println("Putar lagu dari akhir");
                    while (iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    System.out.println("");
                    break;
            }
        }
    }
}