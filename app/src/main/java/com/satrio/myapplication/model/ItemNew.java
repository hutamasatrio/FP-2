package com.satrio.myapplication.model;

public class ItemNew {



        private Long Harga;
        private String Title;
        private String Category ;
        private String Description ;
        private String key;
        private String Img_url;


        //    private int Thumbnail ;
//    private int Harga;

        public ItemNew() {
        }

        public ItemNew(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public ItemNew(String title, String category, String description, String img_url, Long harga) {
            Title = title;
            Category = category;
            Description = description;
            Img_url = img_url;
            Harga = harga;

        }


        public String getTitle() {
            return Title;
        }

        public String getCategory() {
            return Category;
        }

        public String getDescription() {
            return Description;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public void setCategory(String category) {
            Category = category;
        }

        public void setDescription(String description) {
            Description = description;
        }
        public String getImg_url() { return Img_url; }

        public void setImg_url(String img_url) { this.Img_url = img_url; }

        public Long getHarga() { return Harga; }

        public void setHarga(Long harga) { Harga = harga; }
    }
