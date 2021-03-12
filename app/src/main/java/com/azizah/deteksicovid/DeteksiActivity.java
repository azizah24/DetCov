package com.azizah.deteksicovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeteksiActivity extends AppCompatActivity {


    CheckBox riwayat, demam, sesak, batuk, pencernaan, otot, kepala;
    ImageButton deteksi;
    ImageView back;
    TextView kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deteksi);


        riwayat = findViewById(R.id.riwayat);
        demam = findViewById(R.id.demam);
        sesak = findViewById(R.id.sesak);
        batuk = findViewById(R.id.batuk);
        pencernaan = findViewById(R.id.pencernaan);
        otot = findViewById(R.id.otot);
        kepala = findViewById(R.id.kepala);
        kategori = findViewById(R.id.kategori);
        deteksi = findViewById(R.id.deteksi);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        kategori.setText("");
        deteksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String penyakit = "Dari Gejala Yang diinputkan\nAnda Termasuk Kategori : ";

                if(riwayat.isChecked()&& demam.isChecked()&& sesak.isChecked()&& batuk.isChecked()
                        && pencernaan.isChecked() && otot.isChecked() && kepala.isChecked() )
                {
                    penyakit += "Gejala Terinfeksi Virus Covid-19\n\nDikarenakan Anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit dan suhu badan anda >38 anda pun merasa sesak nafas.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }
                else if( riwayat.isChecked() && demam.isChecked()&& sesak.isChecked() )
                {
                    penyakit += "Pasien Dalam Pemantauan (PDP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit dan suhu badan anda >38 anda pun merasa sesak nafas.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas  Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }
                else if( riwayat.isChecked()&& sesak.isChecked()
                        && pencernaan.isChecked() && otot.isChecked() && kepala.isChecked() )
                {
                    penyakit += "Pasien Dalam Pemantauan (PDP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit dan merasa sesak nafas.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( riwayat.isChecked()&& sesak.isChecked() && batuk.isChecked()
                        && pencernaan.isChecked()  && kepala.isChecked() )
                {
                    penyakit += "Pasien Dalam Pemantauan (PDP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit dan merasa sesak nafas.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( riwayat.isChecked() && demam.isChecked() && batuk.isChecked()
                        && pencernaan.isChecked() && otot.isChecked() && kepala.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit dan suhu badan anda >38.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( riwayat.isChecked()  && sesak.isChecked() && batuk.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit dan merasa sesak.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( riwayat.isChecked()  && batuk.isChecked() && pencernaan.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( riwayat.isChecked()  && batuk.isChecked() && pencernaan.isChecked() && otot.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit.\nPPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( riwayat.isChecked()  && demam.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit dan suhu badan anda >38.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( riwayat.isChecked()  && batuk.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( riwayat.isChecked()  && pencernaan.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( riwayat.isChecked()  && otot.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }
                else if( riwayat.isChecked()  && kepala.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }



                else if( riwayat.isChecked()  && demam.isChecked() && otot.isChecked() && kepala.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit dan suhu badan anda >38.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( riwayat.isChecked() && batuk.isChecked()
                        && pencernaan.isChecked() && otot.isChecked() && kepala.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }



                else if( riwayat.isChecked() && pencernaan.isChecked() && otot.isChecked() && kepala.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( demam.isChecked() && batuk.isChecked() && pencernaan.isChecked() && otot.isChecked() && kepala.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan suhu badan anda >38 dan batuk kering.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }
                else if( demam.isChecked() && batuk.isChecked() && pencernaan.isChecked() && sesak.isChecked() && pencernaan.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan suhu badan anda >38, batuk kering dan sesak nafas.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }

                else if( demam.isChecked() && batuk.isChecked() && pencernaan.isChecked() && sesak.isChecked() && pencernaan.isChecked() && otot.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan suhu badan anda >38, batuk kering dan sesak nafas.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }
                else if( demam.isChecked()  )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan suhu badan anda >38.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }
                else if( riwayat.isChecked() && demam.isChecked() )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit dan suhu badan anda >38.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }
                else if( riwayat.isChecked()  )
                {
                    penyakit += "Orang Dalam Pemantauan (ODP)\n\nDikarenakan anda pernah ada riwayat kontak dengan pasien positif , anda pernah berpergian ke negara terjangkit.\nPeriksakan diri Anda di Fasilitas Kesehatan atau Puskesmas Terdekat untuk melakukan pemeriksaan lebih lanjut seperti Rapid test , Swab test/ PCR.\nAnda juga bisa menghubungi 112 atau  081 112 112 112";

                }
                else if( sesak.isChecked() && pencernaan.isChecked() && otot.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }
                else if( sesak.isChecked() && pencernaan.isChecked() && otot.isChecked() && kepala.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }

                else if( sesak.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }

                else if( pencernaan.isChecked() && otot.isChecked() && kepala.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }
                else if( otot.isChecked() && kepala.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }
                else if( kepala.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }

                else if( demam.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }
                else if( demam.isChecked() && sesak.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }
                else if (batuk.isChecked())
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }
                else if (batuk.isChecked() && pencernaan.isChecked() && otot.isChecked())
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }
                else if (batuk.isChecked() && pencernaan.isChecked() && otot.isChecked() && kepala.isChecked())
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }
                else if (batuk.isChecked() && pencernaan.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }
                else if (batuk.isChecked()  && otot.isChecked())
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";

                }

                else if (batuk.isChecked() && kepala.isChecked())
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";
                }
                else if (pencernaan.isChecked() && otot.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";
                }

                else if (pencernaan.isChecked() && otot.isChecked() && kepala.isChecked())
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";
                }
                else if (pencernaan.isChecked() && kepala.isChecked())
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";
                }

                else if (pencernaan.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";
                }

                else if (otot.isChecked() )
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";
                }

                else if (otot.isChecked() && kepala.isChecked())
                {
                    penyakit += "Di luar gejala terpapar Virus COVID-19.\n\nKemungkinan pasien menderita diare atau influenza maka periksakan diri Anda di Fasilitas Kesehatan atau Puskesmas terdekat apabila tidak kunjung sembuh";
                }

                kategori.setText(""+penyakit);

            }
        });


    }


}