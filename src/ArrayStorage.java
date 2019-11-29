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
        boolean deleted = false;
        int i = -1;

        while ((i <= pos) && (!deleted)) {
            i++;
            if (storage[i].uuid.equals(uuid)) {
                deleted = true;
                drift2Left(i);
            }
        }
    }

    private void drift2Left(int removedId) {
        System.arraycopy(storage, removedId + 1, storage, removedId, pos - removedId);
        storage[pos] = null;
        pos = pos - 1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (pos == -1) {
            return new Resume[0];
        }
        return Arrays.copyOfRange(storage, 0, pos + 1);
    }

    int size() {
        return pos + 1;
    }
}
