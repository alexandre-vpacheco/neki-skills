import axios from "axios";

let config = {
  headers: {
    'Content-Type': 'multipart/form-data',
    // "Authorization": `Bearer ${userData.token}`
  }
}
export const RequestAPI = axios.create({
  baseURL: "http://localhost:8080",
});

export const RequestPost = axios.create({
  baseURL: "http://localhost:8080",
  config
});

export const RequestPatch = axios.create({
  baseURL: "http://localhost:8080",
  config
});