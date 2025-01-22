import React from "react"
import Container from "./Container";

interface Props {


}

const ContainerCreator: React.FC<Props> = () => {
    return (
      <div className="overflow-y-auto h-full">
        <Container />
        <Container />
        <Container />
        <Container />
        <Container />
      </div>
    );
}

export default ContainerCreator;