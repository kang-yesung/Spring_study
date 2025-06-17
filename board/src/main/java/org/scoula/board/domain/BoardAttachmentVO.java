package org.scoula.board.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.common.util.UploadFiles;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardAttachmentVO {
    private Long no;
    private Long bno;
    private Long size;
    private String filename;
    private String path;
    private String contentType;
    private Date regDate;

    // of
    // MultipartFile 정보로 BoardAttachmentVo 생성
    public static BoardAttachmentVO of(MultipartFile part, Long bno, String path) {
        return builder()
                .bno(bno)
                .filename(part.getOriginalFilename())     // 원본 파일명 저장
                .path(path)                               // 서버 저장 경로
                .contentType(part.getContentType())       // MIME 타입
                .size(part.getSize())                     // 파일 크기
                .build();
    }

    /**
     * 파일 크기를 사용자 친화적 형태로 변환
     * @return 포맷된 파일 크기 (예: 1.2 MB)
     */
    public String getFileSize() {
        return UploadFiles.getFormatSize(size);
    }
}