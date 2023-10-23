import React, { useState } from "react";
import './Cadastro.css'
import { useNavigate } from "react-router-dom";
import RegistrationForm from "../../Components/RegistrationForm/RegistrationForm";
//import { RequestAPI } from "../../Services/Api";

const Cadastro = () => {
  return (
    <div>
      <RegistrationForm />
    </div>
  )
}

export default Cadastro