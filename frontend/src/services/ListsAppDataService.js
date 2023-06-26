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

    updateList(list) {
        return http.put("/lists/update", list)
    }

    getList(id) {
        return http.get(`/lists/get/${id}`)
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

    updateTask(task) {
        return http.put("/tasks/update", task)
    }

    updateStatus(task) {
        return http.put("/tasks/updateStatus", task)
    }

}

export default new ListsAppDataService();