package interedes.agriculturapp.activities.productor.register_productor;

public interface RegisterProductorView {

    void loadCoordenadas();

    void loadInfo();

    void loadMeses();

    void loadDialogoRegistroExitoso();

    void limpiarCambios();

    void clickEdtMesSiembra();

    void clickEdtMesCosecha();

    void NavigateToParentActivity();

    void registerProductor();
}
