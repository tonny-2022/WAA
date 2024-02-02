import axios from "axios";

const API=axios.create(
    {
    
        baseURL:'http://localhost:8080/api/v3'
    }
    );

export const getAllPosts=()=>API.get('/posts');
export const delelePostByIdApi=(id)=>API.delete(`/posts/${id}`);
export const savePostApi=(post)=>API.post('/posts',post);
export const updatePostApi=(post,id)=>API.put(`/posts/${id}`,post);
export const  getCommetsByPost=(id)=>API.get(`/comments/post/${id}`);