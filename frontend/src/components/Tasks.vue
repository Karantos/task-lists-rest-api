<template>
	<div class="tasks">
		<v-card class="mx-auto" color="secondary">
			<v-list>
				<v-text-field 
					v-model="task.title"
					@click:append-inner="addTask" 
					@keyup.enter="addTask"
					class="pa-3" 
					outlined 
					label="Add Task"
					append-inner-icon="mdi-plus" 
					hide-details 
					clearable
					>
				</v-text-field>

				<v-list-subheader>Tasks</v-list-subheader>
				
				<v-list-item
							v-for="task in tasks"
							:key="task.taskId"
							:title="task.taskTitle"
							@click="statusTask(task)"
							:class="{ 'text-decoration-line-through' : task.status }"
						>   

					<template v-slot:prepend>
						<v-list-item-action start>
							<v-checkbox-btn 
								:model-value="task.status"
							>
						</v-checkbox-btn>
						</v-list-item-action>
					</template>

					<template v-slot:append>
						<v-btn color="grey" icon="mdi-pencil-outline" variant="text"></v-btn>
						<v-btn color="grey" icon="mdi-delete-outline" variant="text" @click="deleteTask(task.id)"></v-btn>
					</template>

				</v-list-item>
			</v-list>
		</v-card>
	</div>
</template>

<script>
import ListsAppDataService from '@/services/ListsAppDataService'

export default {
	name: "tasks",
  data() {
    return {
			componentKey: 0,
      tasks: [],
			task: {
				id: null,
				title: "",
				status: false,
				list: {
					id: null,
				}
			}
    };
  },
	methods: {
		statusTask(task) {
			task.status = !task.status
		},		

		addTask() {
			console.log(addTask)
		},

		getTask(id) {
			ListsAppDataService.getTask(id)
			.then(response => {
				this.tasks = response.data;
				console.log(response.data);
			})
			.catch(error => {
          console.log(error);
      });
		},

		addTask() {
      let data = {
        taskId: this.task.id,
        taskTitle: this.task.title,
        status: this.task.status,
				tasksList: {
					listId: this.$route.params.id
				}
      };

      ListsAppDataService.addTask(data)
        .then(response => {
          this.task.id = response.data.id;
          console.log(response.data);
        })
        .catch(error => {
          console.log(error);
        });
    },

		deleteTask(taskId) {
      ListsAppDataService.deleteTask(taskId)
        .then(response => {
          console.log(response.data);
          const taskIndex = this.tasks.findIndex(task => task.id === taskId)
          this.tasks.splice(taskIndex, 1)			    
        })
        .catch(error => {
          console.log(error);
        });
    },
	},
	mounted() {
		this.getTask(this.$route.params.id)
	}
}
</script>
