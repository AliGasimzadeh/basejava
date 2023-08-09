/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i=0; i<storage.length; i++){
            storage[i]=null;

        }
    }

    void save(Resume r) {
        for(int i = 0; i<storage.length; i++){
            if(storage[i]==null){
                storage[i]=r;
                break;

            }
        }

    }

    Resume get(String uuid) {
        Resume resume1=null ;
        for(Resume resume : storage){
            if(resume!=null && resume.uuid.equals(uuid)){
                return resume;
            }
        resume1=resume;
        }
        return resume1;
    }

    void delete(String uuid) {//add other for loop
       for(int i = 0; i<storage.length; i++) {
      if(storage[i]!=null && storage[i].uuid.equals(uuid)){
       storage[i]=null;
      }
       }
       for(int i = 0; i<storage.length-1; i++){
           if (storage[i]==null&&storage[i+1]!=null){
            storage[i]=storage[i+1];
            storage[i+1]=null;
           }
       }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] nonNullStorage=new Resume[size()];
        int index = 0;
        for(Resume resume : storage){
            if(resume!= null){
                nonNullStorage[index] = resume;
                index++;
            }
        }
        return nonNullStorage;
    }

    int size() {
        int count = 0;
        for(Resume resume: storage){
        if(resume!=null){
          count++;
        }
        }
        return count;
    }
}
