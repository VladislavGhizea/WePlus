const Header: React.FC<{
  parentImage: React.ReactNode;
  parentText: string;
}> = ({ parentImage, parentText }) => (
  <div className="flex h-[3rem] w-full justify center items-center">
    <div className="h-[3rem] w-[3rem] mr-4">{parentImage}</div>
    <h2 className="text-3xl">{parentText}</h2>
  </div>
);
export default Header;
