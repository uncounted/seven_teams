import React from "react";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";

import Header from "./Header";

import { postTodo } from "./redux/modules/write";

const Todo = (props) => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const todo_ref = React.useRef(null);
  const day_ref = React.useRef(null);
  
  const postTodoList = () => {
    dispatch(
      postTodo({
        todo: todo_ref.current.value,
        goalDay: day_ref.current.value,
        checkComplete: false,
      })
    );
    navigate("/");
  };

  return (
    <>
      <Header />
      <Container>
        <h1>작성하기</h1>
        <Box>
          <p>목표 기간</p>
          <input
            type="date"
            ref={day_ref}
            placeholder="  기간을 입력해주세요"
          />
          <p>TODO</p>
          <input
            className="content"
            type="text"
            ref={todo_ref}
            placeholder="  목표를 입력해주세요"
          />
        </Box>
        <button
          onClick={() => {
            postTodoList();
          }}
        >
          작성하기
        </button>
        <button
          onClick={() => {
            navigate("/");
          }}
        >
          취소
        </button>
      </Container>
    </>
  );
};

const Container = styled.div`
  width: 800px;
  height: 600px;
  margin: 20px auto;
  padding: 16px;
  border: 1px solid;
  text-align: center;

  & h1 {
  }

  & button {
    width: 300px;
    height: 30px;
    margin: 20px;
  }
`;

const Box = styled.div`
  width: 600px;
  height: 280px;
  margin: auto;
  padding: 16px;
  border: 1px solid;
  & p {
    text-align: left;
  }
  & input {
    width: 150px;
    display: flex;
    flex-direction: column;
    list-style-type: none;
  }

  .content {
    width: 580px;
    height: 100px;
    
  }
`;

export default Todo;
