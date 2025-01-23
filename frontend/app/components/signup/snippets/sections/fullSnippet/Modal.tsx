import { motion } from "motion/react";
import { Header, Content, Footer } from "./";
import React from "react";

interface ModalProps {
  width: string;
  height: string;
  distanceTop: string;
  distanceLeft: string;
  parentImage: React.ReactNode;
  parentText: string;
  values: { text: string; type: string; options?: string[] }[];
  handleNext: () => void;
  handlePrev: () => void;
}

const Modal: React.FC<ModalProps> = ({
  width,
  height,
  distanceTop,
  distanceLeft,
  parentImage,
  parentText,
  values,
  handleNext,
  handlePrev,
}) => (
  <motion.div
    className="fixed p-4 bg-containerGrey rounded-3xl shadow-lg z-[40]"
    style={{
      top: distanceTop,
      left: distanceLeft,
      width: width,
      height: height,
    }}
    initial={{ opacity: 0, y: -10 }}
    animate={{ opacity: 1, y: 0 }}
    exit={{ opacity: 0, y: -10 }}
    transition={{ duration: 0.3 }}
    role="dialog"
    aria-labelledby="modal-header"
    aria-describedby="modal-content"
  >
    <Header
      // id="modal-header"
      parentImage={parentImage}
      parentText={parentText}
    />
    <Content
      //id="modal-content"
      values={values}
    />
    <Footer handleNext={handleNext} handlePrev={handlePrev} />
  </motion.div>
);

export default Modal;
