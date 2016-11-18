import java.util.ArrayList;

public class Registration {
    // Request repository
    private ArrayList<IRequest> requestList;
    public int count;
    // Add new course, only request with non-exists studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void add(IRequest request) {
        if(exists(request)){
            throw new RuntimeException("Request still existed!.");
        }else
            requestList.add(request);
    }
    // Drop existing course, only request with existing studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void drop(IRequest request) {
        if(exists(request)){
            requestList.remove(request);
        }else
            throw new RuntimeException("No request existed!.");
    }

    // Check whether the request is in repository.
    public boolean exists(IRequest request) {
        if(requestList.contains(request)){
            return true;
        }else
            return false;
    }

    // Count all requests
    public int count() {
       return requestList.size();
    }

    // Count requests by request type
    public int countByType(int type) {
        count = 0;
        for(int i =0 ; i<requestList.size();i++) {
            if (requestList.get(i).getRequestType() == type) {
                count++;
            }
        }
        return count;
    }

    // Count request by course ID
    public int countByCourseID(String courseID) {
        count = 0;
        for(int i =0 ; i<requestList.size();i++){
            if(requestList.get(i).getCourseID().equals(courseID)){
                count++;
            }
        }
        return count;
    }

    // Count request by student ID
    public int countByStudentID(String studentID) {
        count = 0;
        for(int i =0 ; i<requestList.size();i++){
            if(requestList.get(i).getStudentID().equals(studentID)){
                count++;
            }
        }
        return count;
    }


}
