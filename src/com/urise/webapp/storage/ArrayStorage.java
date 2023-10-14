package com.urise.webapp.storage;

import java.util.Arrays;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    final static int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int count;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void update(Resume resume) {
        int index = getResumeIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("ERROR" + " : " + "resume was not found");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume r) {
        int index = getResumeIndex(r.getUuid());
        if (STORAGE_LIMIT <= count) {
            System.out.println("ERROR" + " : " + "Storage is full");
        } else if (index != -1) {
            System.out.println("ERROR" + " : " + "resume has existed yet");
        } else {
            storage[count++] = r;
        }
    }

    public Object get(String uuid) {
        int index = getResumeIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR" + " : " + "resume not found");
            return null;
        } else {
            return storage[index];
        }
    }

    public void delete(String uuid) {
        int index = getResumeIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR" + " : " + "resume has not existed");
        } else {
            storage[index] = storage[--count];
            storage[count] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }

    private int getResumeIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}

