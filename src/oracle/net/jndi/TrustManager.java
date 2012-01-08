package oracle.net.jndi;

import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class TrustManager
  implements X509TrustManager
{
  X509TrustManager nativeTm;

  public TrustManager()
  {
    try
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      localTrustManagerFactory.init((KeyStore)null);
      this.nativeTm = ((X509TrustManager)localTrustManagerFactory.getTrustManagers()[0]);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
  }

  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
  }

  public X509Certificate[] getAcceptedIssuers()
  {
    return this.nativeTm.getAcceptedIssuers();
  }
}

/* Location:           /Users/admin/.m2/repository/com/alibaba/external/jdbc.oracle/10.2.0.2/jdbc.oracle-10.2.0.2.jar
 * Qualified Name:     oracle.net.jndi.TrustManager
 * JD-Core Version:    0.6.0
 */