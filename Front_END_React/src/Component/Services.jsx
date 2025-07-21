import axios from "axios";

const URL = "http://localhost:8000/api";

export const getAllStudent = async () => axios.get(URL);
export const DeleteStudent = async (id) => axios.get(`${URL}/delete/${id}`);
export const SaveStudent = async (data) => axios.post(`${URL}/insert`, data);
export const getDataBYID = async (id) => axios.get(`${URL}/getbyid/${id}`);
export const UpdateById = async (id, data) => axios.post(`${URL}/update/${id}`, data);


