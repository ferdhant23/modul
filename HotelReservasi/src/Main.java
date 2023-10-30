import java.util.Scanner;

/**
 * @ReservationHotel
 */
class ReservasiHotel {
    private String[] namaKamar;
    private boolean[] isTerisi;


    public ReservasiHotel(int jumlahKamar) {
        this.namaKamar = new String[jumlahKamar];
        this.isTerisi = new boolean[jumlahKamar];

        for (int i = 0; i < jumlahKamar; i++) {
            this.namaKamar[i] = "kamar " + (i + 1);
            this.isTerisi[i] = false;
        }
    }

    /**
     *
     */
    public void tampilkanDaftar() {
        System.out.println("Daftar Kamar:");

        for (int i = 0; i < this.namaKamar.length; i++) {

            String status = "tersedia";

            if (this.isTerisi[i]) {
                status = "terisi";
            }
            System.out.println((i + 1) + ". " + this.namaKamar[i] + " - " + status);
        }
        System.out.println("");
    }

    /**
     *
     * @param nomor
     */
    public void pesan(int nomor) {
        int index = nomor - 1;

        if (index < 0 || index >= this.isTerisi.length) {
            System.out.println("Nomor kamar tidak tersedia");
            return;
        }

        if (this.isTerisi[index]) {
            System.out.println("Maaf, kamar sudah terpesan");
            return;
        }

        this.isTerisi[index] = true;
        System.out.println("Berhasil memesan kamaR: " + this.namaKamar[index]);
    }

    public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan jumlah kamar: ");

            int jumlahKamar = scanner.nextInt();
            ReservasiHotel hotel = new ReservasiHotel(jumlahKamar);

            while (true) {
                hotel.tampilkanDaftar();

                System.out.println("Pilih nomor kamar atau ketik 0 untuk keluar:");
                int inputNomor = scanner.nextInt();

                if (inputNomor == 0) {
                    break;
                }
                hotel.pesan(inputNomor);
            }


            scanner.close();
        }

    }
}
