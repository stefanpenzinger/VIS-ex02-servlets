package task_2_2_e_EnvironmentServiceServlet.c;

public interface IEnvService {
    public String[] requestEnvironmentDataTypes();
    public EnvData requestEnvironmentData(String _type);
    public EnvData[] requestAll();
}
