package com.practica.data.model;

public class User {

    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;


    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public class Address{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        public String getStreet() {
            return street;
        }

        public String getSuite() {
            return suite;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        class Geo {
            private String lat;
            private String lng;

            public String getLat() {
                return lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }
        }
    }

    public class Company {

        private String name;
        private String catchPhrase;
        private String bs;

        public String getName() {
            return name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }

    }

    public String getStringUser(){
        return "Name: "+getName()+"\nUsername: "+getUsername()+"\nEmail: "+getEmail()+"\nStreet: "+getAddress().getStreet()+"\nSuite: "+getAddress().getSuite()+"\nCity: "+getAddress().getCity()+"\nZipCode: "+getAddress().getZipcode()+"\nPhone: "+getPhone()+"\nWebSite: "+getWebsite()+"\nCompany Name: "+getCompany().getName()+"\ncatchPhrase: "+getCompany().getCatchPhrase()+"\nBS: "+getCompany().getBs();
    }
}
