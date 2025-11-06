/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kelas;

public class Sesion {
    private static String Username, Email, Fullname, Status;

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String Username) {
        Sesion.Username = Username;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String Email) {
        Sesion.Email = Email;
    }

    public static String getFullname() {
        return Fullname;
    }

    public static void setFullname(String Fullname) {
        Sesion.Fullname = Fullname;
    }

    public static String getStatus() {
        return Status;
    }

    public static void setStatus(String Status) {
        Sesion.Status = Status;
    }
}
