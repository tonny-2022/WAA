import React from "react";
import { useParams } from "react-router-dom";
import { newArrPosts } from "./Posts";
import { useLocation } from "react-router-dom";

import { delelePostByIdApi,updatePostApi } from "../Api/Api";
import { useState } from "react";
function PostDetail(){
     //const[postId]=useParams() 
    //const post=newArrPosts.find((post)=>post.id===parseInt(postId));
   
    const { state } = useLocation();
    const[updateMsg,setUpdateMsg]=useState('');
    const post = state?.post;
    if(!post){
       // return <div>Post not found</div>;

    }

    const deletePostById=(id)=>{
 
        delelePostByIdApi(id)
         .then(()=>{
            setUpdateMsg(`Record with id ${id} sucessfully deleted`);
       })
       //.catch(setUpdateMsg(`Record with id ${id} failed to delete!!!`));
       .catch(error=>console.log(error));
    

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
        .catch(setUpdateMsg(`Record with id ${id} fail to update!!!`));
       

    }

 return (


    <div className="container">
     <form >
            <div className="card mx-auto card-post">
            {updateMsg && <div className="alert alert-warning">{updateMsg}</div>}
            <div className="card-body">
            <h5>Post Detail </h5>
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
        <div className="form-group d-flex">
            <div className='me-2'>
                <button type="submit" className="btn btn-success btn-flat" name="btnUpdatePost" onClick={updatePost}>Update </button>
            </div>
            <div>
                <button type="submit" className="btn btn-danger btn-flat" onClick={()=>deletePostById(post.id)}>Delete </button>
            </div>
        </div>
        

      </div>
    </div>
    </form>
  </div>


)


}

 export default PostDetail;

