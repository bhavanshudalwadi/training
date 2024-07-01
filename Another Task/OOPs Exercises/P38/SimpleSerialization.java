import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleSerialization {

    public static void serialize(Object obj, OutputStream outputStream) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            Class<?> clazz = obj.getClass();
            objectOutputStream.writeObject(clazz.getName());

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                objectOutputStream.writeObject(field.getName());
                objectOutputStream.writeObject(field.get(obj));
            }
        }
    }

    public static Object deserialize(InputStream inputStream) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            String className = (String) objectInputStream.readObject();
            Class<?> clazz = Class.forName(className);
            Object obj = clazz.newInstance();

            Map<String, Field> fieldMap = new HashMap<>();
            for (Field field : clazz.getDeclaredFields()) {
                fieldMap.put(field.getName(), field);
            }

            while (objectInputStream.available() > 0) {
                String fieldName = (String) objectInputStream.readObject();
                Object fieldValue = objectInputStream.readObject();

                Field field = fieldMap.get(fieldName);
                if (field != null) {
                    field.setAccessible(true);
                    field.set(obj, fieldValue);
                }
            }

            return obj;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // Serialize an object
        User originalUser = new User("John Doe", 25);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        serialize(originalUser, outputStream);

        // Deserialize the object
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        User deserializedUser = (User) deserialize(inputStream);

        // Verify the deserialized object
        System.out.println("Original User: " + originalUser);
        System.out.println("Deserialized User: " + deserializedUser);
    }
}

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
