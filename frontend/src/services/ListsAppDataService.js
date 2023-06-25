import http from  "../http-common"

class ListsAppDataService {
    // List methods
    getAllLists() {
        return http.get("/lists/getAll");
    }

    addList(data) {
        return http.post("/lists/add", data);
    }

    deleteList(id) {
        return http.delete(`/lists/delete/${id}`);
    }

    updateList(data) {
        return http.put("/lists/update", data)
    }

    // Task methods
    getTask(id) {
        return http.get(`/lists/getTask/${id}`)
    }

    addTask(data) {
        return http.post("/tasks/add", data);
    }

    deleteTask(id) {
        return http.delete(`/tasks/delete/${id}`)
    }

    updateTask(data) {
        return http.put("/tasks/update", data)
    }

}

export default new ListsAppDataService();