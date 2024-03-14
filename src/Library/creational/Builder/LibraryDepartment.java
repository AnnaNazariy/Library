package Library.creational.Builder;

public class LibraryDepartment {
    private final String name;
    private final String description;
    private final boolean hasSpecialCollection;

    private LibraryDepartment(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.hasSpecialCollection = builder.hasSpecialCollection;
    }

    @Override
    public String toString() {
        return "LibraryDepartment{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hasSpecialCollection=" + hasSpecialCollection +
                '}';
    }

    public static class Builder {
        private final String name;
        private String description;
        private boolean hasSpecialCollection;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setHasSpecialCollection(boolean hasSpecialCollection) {
            this.hasSpecialCollection = hasSpecialCollection;
            return this;
        }

        public LibraryDepartment build() {
            return new LibraryDepartment(this);
        }
    }
}



