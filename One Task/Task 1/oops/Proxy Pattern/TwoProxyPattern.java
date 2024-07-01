package ProxyPattern;

interface Resource {
    void accessResource();
}

class RealResource implements Resource {
    @Override
    public void accessResource() {
        System.out.println("Accessing the costly resource.");
    }
}

class ProxyResource implements Resource {
    private RealResource realResource;
    private String accessKey;

    public ProxyResource(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public void accessResource() {
        if (checkAccessKey()) {
            if (realResource == null) {
                realResource = new RealResource();
            }
            realResource.accessResource();
        } else {
            System.out.println("Access denied. Invalid access key.");
        }
    }

    private boolean checkAccessKey() {
        // Check if the access key is valid (for example, a password or token
        // validation).
        return "secretKey".equals(accessKey);
    }
}

public class TwoProxyPattern {
    public static void main(String[] args) {
        Resource resource = new ProxyResource("secretKey");
        resource.accessResource();
    }
}
