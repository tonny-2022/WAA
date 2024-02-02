import React from "react";
import { useParams } from "react-router-dom";


const PostDetails = ({post}) => {
  //const {postId} = useParams();
  // Find the post with the matching postId
  //const post = arrPost.find((post) => post.id === parseInt(postId));


  if (!post) {
    return <div>Post not found</div>;
  }
    return(

        <div className="container">
        <div className="card mx-auto card-posts">
          <div className="card-body">
            <p className="card-text">Id: {post.id}</p>
            <p className="card-text">Title: {post.title}</p>
            <p className="card-text">Author: {post.author}</p>
          </div>
        </div>
      </div>

                 
    )
  
}

export default PostDetails;