<template>
  <div class="home">
    <v-card class="mx-auto">
      <v-list lines="two">
        <v-list-subheader>My Lists</v-list-subheader>

          <v-list-item
            v-for="list in lists"
            :key="list.listId"
            :title="list.listName"
            :subtitle="list.listDescription"
          >   
          
          <template v-slot:prepend>
            <v-avatar color="grey">
              <v-icon color="white-darken-1">mdi-view-list</v-icon>
            </v-avatar>
          </template>

          <template v-slot:append>
            <v-btn color="grey" icon="mdi-playlist-edit" variant="text" @click="getUpdateListId(list.listId)"></v-btn>
            <v-btn color="grey" icon="mdi-playlist-remove" variant="text" @click="deleteList(list.listId)"></v-btn>
            <v-btn color="grey" icon="mdi-information" variant="text" @click="viewList(list.listId)"></v-btn>
          </template>
        </v-list-item>
      </v-list>
    </v-card>

  </div>
</template>

<script>
import ListsAppDataService from "@/services/ListsAppDataService";

export default {
  name: "home",
  data() {
    return {
      lists: [],
    };
  },
  methods: {
    viewList(listId) {
      this.$router.push({name: 'tasks', params: { id: listId }});
    },

    getUpdateListId(listId) {
        this.$router.push({name: 'update-list', params: { id: listId }});
    },

    getAllLists() {
      ListsAppDataService.getAllLists()
        .then(response => {
          this.lists = response.data;
          console.log(response.data);
        })
        .catch(error => {
          console.log(error);
        });
    },
    
    deleteList(listId) {
      ListsAppDataService.deleteList(listId)
        .then(response => {
          console.log(response.data);
          const listIndex = this.lists.findIndex(list => list.id === listId)
          this.lists.splice(listIndex, 1)			    
        })
        .catch(error => {
          console.log(error);
        });
    },    
  },
  mounted() {
    this.getAllLists();
  }
  
}
</script>