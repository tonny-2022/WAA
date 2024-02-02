

import {React, useContext} from "react";
import { useEffect } from "react";
import { useLocation } from "react-router-dom";


import { delelePostByIdApi,updatePostApi,getCommetsByPost } from "../Api/Api";
import { useState } from "react";
import { appContext } from "../../AppContext";


function PostDetail(){
 
   
    const { state } = useLocation();
    const[updateMsg,setUpdateMsg]=useState('');
    const post = state?.post;
    const[arrComment,setArrComment]=useState([]);
    const [productId,setProductId]=useContext(appContext);

    const [newproductId,setNewProductId]=useState(setProductId);
    setNewProductId(5);

    useEffect(()=>{
        fetchCommentsByPost(post.id);

      },[post]);
    
      const fetchCommentsByPost=(postId)=>{
       
        getCommetsByPost(postId).then(response=>{
          setArrComment(response.data);  
          

        })
        
        .catch(error=>console.log(error))
    }
   
   
    if(!post){
        return <div><h5>No post found</h5></div>;

    }

    const deletePostById=(id)=>{
 
        delelePostByIdApi(id)
         .then(()=>{
            setUpdateMsg(`Record with id ${id} sucessfully deleted`);
       })
       .catch(setUpdateMsg(`Record with id ${id} failed to delete!!!`));
       
    

    }

    const updatePost=(event)=>{

        event.preventDefault();
        const id=event.target.form.postid.value;
        const title = event.target.form.title.value;
        const author = event.target.form.author.value;
        const content = event.target.form.content.value;
        const values={title,author,content};
        
        updatePostApi(values,id)
        .then(setUpdateMsg(`Record with id ${id} sucessfully updated`))
        .catch();
       

    }

 return (


   <div className="container">
     <form >
     
            <div className="card mx-auto card-post">
            {updateMsg && <div className="alert alert-warning">{updateMsg}</div>}
          
            <div className="card-body">
            <h5>Post Detail :{newproductId}</h5>
            <div className="form-group">
                <label>Id:</label>
                <input type="text" className="form-control col-sm-6" value={post?.id} readOnly name="postid"/>
            </div>
            <div className="form-group">
                <label>Title:</label>
                <input type="text" className="form-control col-sm-6" defaultValue={post?.title} name="title"/>
            </div>
            <div className="form-group">
                <label>Author:</label>
                <input type="text" className="form-control col-sm-6 mb-3" defaultValue={post?.author} name="author"/>
            </div>
            
            <div className="form-group">
                <label>Content:</label>
                <input type="text" className="form-control col-sm-6 mb-3" defaultValue={post?.content}  name="content"/>
            </div>

            <div className="card mb-3">
                <div class="card-body">

                    <div className="form-group">
                    <label>Comments List</label>
                    <ul className="list-group">
                    {
                    arrComment.map( comment=>(
                     <li className="list-group-item" key={comment.id}>
                            <p>{comment.name}</p>
                        </li>
                  
                    ))} 
                 </ul>
                </div>
            </div>
          </div>

        <div className="form-group d-flex">
            <div className='me-2'>
                <button type="submit" className="btn btn-success btn-flat" name="btnUpdatePost" onClick={updatePost}>Update Post </button>
            </div>
            <div>
                <button type="submit" className="btn btn-danger btn-flat" onClick={()=>deletePostById(post.id)}>Delete post </button>
            </div>
        </div>
        

      </div>
    </div>

    </form>
  </div>


)


}

 export default PostDetail;

