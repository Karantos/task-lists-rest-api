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

      <v-btn type="submit" block class="mt-2" color="secondary" @click="updateList" :disabled="!list.name">Update list
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
  name: "update-list",
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
    updateList() {
      let list = {
        listId: this.$route.params.id,
        listName: this.list.name,
        listDescription: this.list.description
      };

      ListsAppDataService.updateList(list)
        .then(response => {
          console.log(response.data)
          this.message = `You have updated the list with id ${list.listId} successfully!`;
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
}

</script>