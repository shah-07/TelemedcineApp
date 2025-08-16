

package Tasfia;

    public class DoctorRecord {
        private String doctorName;
        private String department;
        private String time;
        private double fee;

        public DoctorRecord(String doctorName, String department, String time, double fee) {
            this.doctorName = doctorName;
            this.department = department;
            this.time = time;
            this.fee = fee;
        }

        public String getDoctorName() { return doctorName; }
        public String getDepartment() { return department; }
        public String getTime() { return time; }
        public double getFee() { return fee; }
    }



