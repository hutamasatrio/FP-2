package com.satrio.myapplication.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.satrio.myapplication.Login;
import com.satrio.myapplication.R;
import com.satrio.myapplication.seting.TampilAccount;
import com.satrio.myapplication.adapter.PreferenceHelper;

import com.satrio.myapplication.seting.FAQ;
import com.satrio.myapplication.seting.History;


public class Fragment5 extends Fragment implements View.OnClickListener {
private CardView card15, card16, card17, card18;
    PreferenceHelper instance;
    AlertDialog.Builder mAlertAboutApp;
    LayoutInflater mAlertAboutAppInflater;
    View dialogView;

    public Fragment5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View show1 = inflater.inflate(R.layout.activity_fragment5, container, false);

        card15 = show1.findViewById(R.id.card15);
        card15.setOnClickListener(this);
        card16 = show1.findViewById(R.id.card16);
        card16.setOnClickListener(this);
        card17= show1.findViewById(R.id.card17);
        card17.setOnClickListener(this);
        card18 = show1.findViewById(R.id.card18);
        card18.setOnClickListener(this);


        return show1;}


        public void onClick(View show1) {
            switch (show1.getId()) {
                case R.id.card15:
                    startActivity(new Intent(getActivity(), TampilAccount.class));
                    getActivity().overridePendingTransition(R.anim.move_up, R.anim.exit_up);
                    getActivity().finish();
                    break;
                case R.id.card16:
                    mAlertAboutApp = new AlertDialog.Builder(getView().getContext());
                    mAlertAboutAppInflater = getLayoutInflater();
                    dialogView = mAlertAboutAppInflater.inflate(R.layout.about_us, null);
                    mAlertAboutApp.setView(dialogView);
                    mAlertAboutApp.setCancelable(true);
                    mAlertAboutApp.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    mAlertAboutApp.show();
                    break;
                case R.id.card17:
                    startActivity(new Intent(getActivity(), FAQ.class));
                    getActivity().overridePendingTransition(R.anim.move_up, R.anim.exit_up);
                    break;
                case R.id.card18:

                    startActivity(new Intent(getActivity(), History.class));
                    getActivity().overridePendingTransition(R.anim.move_up, R.anim.exit_up);

                    break;

            }}
//    void showDialog() {
//        DialogFragment newFragment = MyAlertDialogFragment.newInstance(R.string.app_name);
//        newFragment.show(getFragmentManager(), "dialog");
//    }
//
//    public void doPositiveClick() {
//        Toast.makeText(getContext(),"Clicked Ok",Toast.LENGTH_SHORT).show();
//    }
//
//    public void doNegativeClick() {
//        Toast.makeText(getContext(),"Clicked Cancel", Toast.LENGTH_SHORT).show();
//    }
//
//    public static class MyAlertDialogFragment extends DialogFragment {
//
//        public static MyAlertDialogFragment newInstance(int title) {
//            MyAlertDialogFragment frag = new MyAlertDialogFragment();
//            Bundle args = new Bundle();
//            args.putInt("title", title);
//            frag.setArguments(args);
//            return frag;
//        }
//
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            int title = getArguments().getInt("title");
//
//            return new AlertDialog.Builder(getActivity())
//                    .setIcon(R.drawable.logout)
//                    .setTitle(title)
//                    .setPositiveButton("ok",new DialogInterfaceOnClickListener() {
//                        public void onClick(DialogInterface dialog,
//                                            int whichButton) {
//                            ((DialogFragmentActivity) getActivity())
//                                    .doPositiveClick();
//                        }
//                    })
//                    .setNegativeButton("Cancel",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog,
//                                                    int whichButton) {
//                                    ((DialogFragmentActivity) getActivity())
//                                            .doNegativeClick();
//                                }
//                            }).create();
//        }
//    }
//}


    }


//        card2 =  show.findViewById(R.id.card2);
////        card2 =  show.findViewById(R.id.card2);
////        card3 =  show.findViewById(R.id.card3);
//          card4 =  show.findViewById(R.id.card4);
////        card2.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent intent = new Intent(getActivity(), TambahDistributor.class);
////                getActivity().startActivity(intent);
////            }
//        card4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
////
////                // set title dialog
////                alertDialogBuilder.setTitle("Keluar dari aplikasi?");
////
////                // set pesan dari dialog
////                alertDialogBuilder
////                        .setMessage("Klik Ya untuk keluar!")
////                        .setIcon(R.mipmap.ic_launcher)
////                        .setCancelable(false)
////                        .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
////                            public void onClick(DialogInterface dialog,int id) {
////                                // jika tombol diklik, maka akan menutup activity ini
//                                instance.setLogin(false);
//                Intent intent = new Intent(getActivity(), Login.class);
//               getActivity().startActivity(intent);
//               getActivity().finish();


//
//                            }
//                        })
//                        .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                // jika tombol ini diklik, akan menutup dialog
//                                // dan tidak terjadi apa2
//                                dialog.cancel();
//                            }
//                        });
//
//                // membuat alert dialog dari builder
//                AlertDialog alertDialog = alertDialogBuilder.create();
//
//                // menampilkan alert dialog
//                alertDialog.show();
//            }
//
//        });





//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//                case R.id.card1:
//                    startActivity(new Intent(getActivity(), Account.class));
//                    getActivity().overridePendingTransition(R.anim.move_up, R.anim.exit_up);
//                    break;
//                case R.id.card2:
//                    mAlertAboutApp = new AlertDialog.Builder(getActivity());
//                    mAlertAboutAppInflater = getLayoutInflater();
//                    dialogView = mAlertAboutAppInflater.inflate(R.layout.activity_about_us, null);
//                    mAlertAboutApp.setView(dialogView);
//                    mAlertAboutApp.setCancelable(true);
//                    mAlertAboutApp.setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dialogInterface.dismiss();
//                        }
//                    });
//                    mAlertAboutApp.show();
//
//                    break;
//                case R.id.card3:
//                    startActivity(new Intent(getActivity(), FAQ.class));
//                    getActivity().overridePendingTransition(R.anim.move_up, R.anim.exit_up);
//                    break;
//                case R.id.card4:
//                    startActivity(new Intent(getActivity(), Rekomendasi.class));
//                    getActivity().overridePendingTransition(R.anim.move_up, R.anim.exit_up);
//                    break;
//
//    }



