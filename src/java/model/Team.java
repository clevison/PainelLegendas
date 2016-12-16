package model;

public class Team {
	private int id_Team;
        private String name;
        private String message;
        private String photo;
        private int admim;
        
        public int getId_Team() {
            return id_Team;
        }

        public void setId_Team(int id_Team) {
            this.id_Team = id_Team;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getAdmim() {
            return admim;
        }

        public void setAdmim(int admim) {
            this.admim = admim;
        }
}
