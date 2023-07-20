public class Main {
    public static void main(String[] args) {
        try {
            Authentication.verificationAuthentication("lodasaSDASDASDASsdasg", "pas", "pas");
        } catch (WrongLoginException | WrongPassException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}