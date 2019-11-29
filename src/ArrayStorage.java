import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];

    private int pos = -1; // empty, position of last insertion

    void clear() {
        for (int i = 0; i <= pos; i++) {
            storage[i] = null;
        }
        pos = -1;
    }

    void save(Resume r) {
        if (get(r.uuid) != null) return;

        pos = pos + 1;
        storage[pos] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i <= pos; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int i = -1;
        while (i <= pos) {
            i++;
            if (storage[i].uuid.equals(uuid)) {
                drift2Left(i);
                break;
            }
        }
    }

    private void drift2Left(int index) {
        System.arraycopy(storage, index + 1, storage, index, pos - index);
        storage[pos] = null;
        pos--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, pos + 1);
    }

    int size() {
        return pos + 1;
    }
}
