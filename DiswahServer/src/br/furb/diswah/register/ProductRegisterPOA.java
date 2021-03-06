package br.furb.diswah.register;

/**
 * 
 * @author Andr� Felipe de Almeida {almeida.andref@gmail.com}
 */
@SuppressWarnings({"unchecked","rawtypes"})
public abstract class ProductRegisterPOA extends org.omg.PortableServer.Servant implements ProductRegisterOperations, org.omg.CORBA.portable.InvokeHandler {

	private static java.util.Hashtable _methods = new java.util.Hashtable();
	static {
		_methods.put("save", new java.lang.Integer(0));
		_methods.put("find", new java.lang.Integer(1));
		_methods.put("list", new java.lang.Integer(2));
	}

	public org.omg.CORBA.portable.OutputStream _invoke(String $method,
			org.omg.CORBA.portable.InputStream in,
			org.omg.CORBA.portable.ResponseHandler $rh) {
		org.omg.CORBA.portable.OutputStream out = null;
		java.lang.Integer __method = (java.lang.Integer) _methods.get($method);
		if (__method == null)
			throw new org.omg.CORBA.BAD_OPERATION(0,
					org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

		switch (__method.intValue()) {
		case 0: // register/ProductRegister/save
		{
			String p1 = in.read_string();
			String $result = null;
			$result = this.save(p1);
			out = $rh.createReply();
			out.write_string($result);
			break;
		}

		case 1: // register/ProductRegister/find
		{
			int p1 = in.read_long();
			String $result = null;
			$result = this.find(p1);
			out = $rh.createReply();
			out.write_string($result);
			break;
		}

		case 2: // register/ProductRegister/list
		{
			String $result = null;
			$result = this.list();
			out = $rh.createReply();
			out.write_string($result);
			break;
		}

		default:
			throw new org.omg.CORBA.BAD_OPERATION(0,
					org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
		}

		return out;
	} // _invoke

	// Type-specific CORBA::Object operations
	private static String[] __ids = { "IDL:register/ProductRegister:1.0" };

	public String[] _all_interfaces(org.omg.PortableServer.POA poa,
			byte[] objectId) {
		return (String[]) __ids.clone();
	}

	/**
	 * @return register
	 */
	public ProductRegister _this() {
		return ProductRegisterHelper.getInstance().narrow(super._this_object());
	}

	/**
	 * @param orb
	 * @return register
	 */
	public ProductRegister _this(org.omg.CORBA.ORB orb) {
		return ProductRegisterHelper.getInstance().narrow(super._this_object(orb));
	}

}