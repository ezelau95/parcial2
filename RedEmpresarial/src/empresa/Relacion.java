package empresa;

public class Relacion {

	private Empleado e1;
	private Empleado e2;

	public Relacion(Empleado e1, Empleado e2) {
		super();
		this.e1 = e1;
		this.e2 = e2;
	}

	public Empleado getE1() {
		return e1;
	}

	public Empleado getE2() {
		return e2;
	}

}
