package com.hyperwallet.rest.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hyperwallet.rest.ws.ToDoTask;
import java.util.List;

@Path("/HyperWalletToDoProject")
public class HyperWalletWS {

	static List<ToDoTask> ToDoList;
	static Integer index = 0;
	
	//End Point Method to Create
	@POST
	@Path("/Create")
	@Produces(MediaType.TEXT_PLAIN)
	public synchronized String CreateItem(@QueryParam("Title")String Title, @QueryParam("Description")String Description)
	{
		ToDoTask iToDo = new ToDoTask();
		
		//Add the Item to the list
		iToDo.setTitle(Title);
		iToDo.setDescription(Description);
		iToDo.setCompleted("OPEN");
		index++;
		iToDo.setId(index.toString());
		
		ToDoList.add(iToDo);
		
		//Return success
		return "SUCCESS";
	}
	
	//End Point Method to Delete
	@DELETE
	@Path("/Delete")
	@Produces(MediaType.TEXT_PLAIN)
	public synchronized String DeleteItem(@QueryParam("Type")String Type, @QueryParam("Value")String Value)
	{		
		//Get the index of the To Do item
		int index = FindToDoIndex(Type,Value);
		
		//If item is not found return failure
		if(index < 0)
		{
			return "FAILED (ELEMENT NOT FOUND)";
		}
		else
		{
			ToDoList.remove(index);
			
			return "SUCCESS";
		}
	}
	
	//End Point Method to Update
	@PUT
	@Path("/Update")
	@Produces(MediaType.TEXT_PLAIN)
	public synchronized String UpdateItem(@QueryParam("Title")String Title, @QueryParam("Description")String Description, @QueryParam("Completed") String Status)
	{
		//Get the index of the To Do item
		int index = FindToDoIndex("Title",Title);
		
		//If item is not found return failure
		if(index < 0)
		{
			return "FAILED (ELEMENT NOT FOUND)";
		}
		else
		{
		
			ToDoTask iToDo = new ToDoTask();
			
			iToDo.setTitle(Title);
			iToDo.setDescription(Description);
			iToDo.setCompleted(Status);
			iToDo.setId(ToDoList.get(index).getId());
			
			//Update item and return success
			ToDoList.set(index,iToDo);
			
			return "SUCCESS";
		}		
	}
	
	//End Point Method to Retrieve ToDo Item
	@GET
	@Path("/Find")
	@Produces(MediaType.TEXT_PLAIN)
	public synchronized String FindItem(@QueryParam("Type")String Type, @QueryParam("Value")String Value)
	{
		//Get the index of the To Do item
				int index = FindToDoIndex(Type,Value);
				
				//If item is not found return failure
				if(index < 0)
				{
					return "FAILED (ELEMENT NOT FOUND)";
				}
				else
				{
					ToDoTask iToDo = new ToDoTask();
					
					iToDo = ToDoList.get(index);
					
					return "SUCCESS " + "(" + iToDo.getTitle() + "," + iToDo.getDescription() + "," + iToDo.getCompleted() + ")";
				}
	}
	
	//Private method to retrive index of a todo item
	private int FindToDoIndex(String Type, String Value)
	{
		for(int i=0; i < ToDoList.size(); i++)
		{
			ToDoTask iToDo = new ToDoTask();
			
			iToDo = ToDoList.get(i);
			
			//If successful match, then delete and return success
			if(Type.equalsIgnoreCase("ID"))
			{
				if(iToDo.getId().equalsIgnoreCase(Value))
				{					
					return i;
				}
			}
			else if(Type.equalsIgnoreCase("Title"))
			{
				if(iToDo.getTitle().equalsIgnoreCase(Value))
				{					
					return i;
				}
			}
			else if(Type.equalsIgnoreCase("Description"))
			{
				if(iToDo.getTitle().equalsIgnoreCase(Value))
				{				
					return i;
				}
			}
		}
		
		return -1;
	}
}
