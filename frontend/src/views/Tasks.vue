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
						clearable
						required
						placeholder="Enter task name to add task"
						>
					</v-text-field>
					
				<v-list-subheader>Tasks</v-list-subheader>
				
				<v-list-item
					v-for="task in tasks"
					:key="task.taskId"
					@click="updateTaskStatus(task)"
				>   
					
					<v-list-item-title 
						:class="{ 'text-decoration-line-through' : task.status }"
					> 
						{{ task.taskTitle }}
					</v-list-item-title>
					
					<template v-slot:prepend>
						<v-list-item-action start>
							<v-checkbox-btn 
								:model-value="task.status"
							>
						</v-checkbox-btn>
						</v-list-item-action>
					</template>
					
					<template v-slot:append>
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
			tasks: [],
			message: "",
			task: {
				id: null,
				title: "",
				status: false,
				list: {
					id: null,
				},
			}
		};
	},
	methods: {
		status(task) {
			task.status = !task.status;
		},

		addTask() {
			console.log(addTask)
		},

		getTask(taskId) {
			ListsAppDataService.getTask(taskId)
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
					this.$router.go(0);
				})
				.catch(error => {
					console.log(error);
				});
		},

		deleteTask(id) {
			ListsAppDataService.deleteTask(id)
				.then(response => {
					console.log(response.data);
					const taskIndex = this.tasks.findIndex(task => task.id === id) // finds index of array(tasks) of a task which id == id of the task to delete
					this.tasks.splice(taskIndex, 1) // removes 1 element from array index that is defined by taskIndex
				})
				.catch(error => {
					console.log(error);
				});
		},

		updateTaskStatus(task) {
			let data = task;
			task.status = !task.status;

			ListsAppDataService.updateTask(data)
				.then(response => {
					task.status = !task.status;
					console.log(response.data);
					this.$router.go(0);
				})
				.catch(error => {
					console.log(error);
				});
		},

		updateTask(task) {
			let data = task;

			ListsAppDataService.updateTask(data)
				.then(response => {
					data.title = this.task.title;
					console.log(response.data);
					this.$router.go(0);
				})
				.catch(error => {
					console.log(error);
				});
		}
	},
	mounted() {
		this.getTask(this.$route.params.id)
	}
}
</script>
