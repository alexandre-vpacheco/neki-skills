import React from "react";
import './Home.css'
import { useNavigate } from "react-router-dom";

const Home = () => {

    const navigate = useNavigate();

    const handleCadastrarSkill = () => {

    }

    const handleSair = () => {
        navigate(`/Login`)
    }


    return (
        <>
            <div>
                <header className="header-home">
                    <h2 >Home Page: Cadastrar Skills</h2>
                    <button onClick={handleSair} className="sairButton">Logout</button>
                </header>
            </div>
            <div className="r-container-home">
                <span className="title">Minhas Skills</span>
                <form className="form-home">
                    <input type="text" placeholder="Skill 1" />
                    <input type="text" placeholder="Skill 2" />
                    <input type="text" placeholder="Skill 3" />
                    <button className="button1" onClick={handleCadastrarSkill}>Cadastrar</button>
                </form>
            </div>
        </>


    )
}

export default Home