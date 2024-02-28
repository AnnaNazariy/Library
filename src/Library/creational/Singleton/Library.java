package Library.creational.Singleton;
 public class Library {
        private static Library library = null;
        private static final String name = "Наукова бібліотека ЧНУ";
        private static String location = "Вулиця Лесі Українки,23";
        private static String phoneNumber = "+38037258760";

        private Library() {}

        public static Library getInstance() {
            if (library == null) {
                library = new Library();
                return library;
            }
            return library;
        }

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String loc) {
            location = loc;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String number) {
            phoneNumber = number;
        }
    }


