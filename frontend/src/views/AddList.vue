<template>
  <v-sheet width="600" ref="addForm" class="mx-auto ma-6">
    <v-form @submit.prevent>
      <v-text-field 
        v-model="list.name" 
        :rules="list.rules" 
        label="List name *"
        clearable
        required
      >
      </v-text-field>
      <v-text-field 
        v-model="list.description"  
        label="List description"
        clearable
      >
      </v-text-field>
      <v-btn type="submit" block class="mt-2" color="secondary" @click="addList" :disabled="!list.name">Add list
        <v-overlay
          activator="parent"
          location-strategy="connected"
          scroll-strategy="close"
        >
          <v-card class="pa-2">
            {{ message }}
          </v-card>
        </v-overlay>
      </v-btn>
    </v-form>
  </v-sheet>
</template>

<script>
import ListsAppDataService from '@/services/ListsAppDataService';

export default {
  name: "add-list",
  data() {
    return {
      message: '',
      list: {
        id: null,
        name: '',
        description: '',
        rules: [
          value => {
            if (value) return true
            return 'You must enter a name for your list!'
          },
        ]
      },
      submitted: false   
    };
  },
  methods: {
    addList() {
      let data = {
        listId: this.list.id,
        listName: this.list.name,
        listDescription: this.list.description
      };

      ListsAppDataService.addList(data)
        .then(response => {
          this.list.id = response.data.id;
          console.log(response.data);
          this.message = "You have added a list successfully! Add another one or return to Homepage to view you lists.";
        })
        .catch(error => {
          console.log(error);
        });
    },
  }
}

</script>