package am.aca.kinopopoq.service.implementation;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class LimitOffsetPageRequest implements Pageable {

    private final int limit;
    private final int offset;
    private final Sort sort;

    public LimitOffsetPageRequest(int limit, int offset) {
        this(limit, offset, null);
    }

    public LimitOffsetPageRequest(int limit, int offset, Sort sort) {
        this.sort = sort;
        this.limit = limit;
        this.offset = offset;
    }

    @Override
    public int getPageNumber() {
        return offset / limit;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return new LimitOffsetPageRequest(getPageNumber() + 1, getPageSize(), getSort());
    }

    public LimitOffsetPageRequest previous() {
        return getPageNumber() == 0 ? this : new LimitOffsetPageRequest(getPageNumber() - 1, getPageSize(), getSort());
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    public Pageable first() {
        return new LimitOffsetPageRequest(0, getPageSize(), getSort());
    }

    @Override
    public boolean hasPrevious() {
        return offset > 0;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + offset;
        result = prime * result + limit;

        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        LimitOffsetPageRequest other = (LimitOffsetPageRequest) obj;
        return this.offset == other.offset && this.limit == other.limit;
    }

}
